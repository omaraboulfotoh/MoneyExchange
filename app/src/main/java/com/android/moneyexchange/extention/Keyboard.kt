package com.android.moneyexchange.extention

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.CheckResult
import androidx.core.content.ContextCompat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.selects.whileSelect
import java.util.concurrent.Flow
import java.util.concurrent.TimeUnit

/**
 * Hides the soft input window.
 */

fun View.hideKeyboard() {
    val imm = (context.getSystemService(Context.INPUT_METHOD_SERVICE) ?: return)
            as InputMethodManager

    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun Activity.hideSoftKeyboard() {
    var view: View? = currentFocus
    if (view == null) {
        view = View(this)
    }
    (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
        view.windowToken,
        0
    )
    currentFocus?.let {
        val inputMethodManager =
            ContextCompat.getSystemService(this, InputMethodManager::class.java)!!
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun Activity.hideInputType(view: View) {
    view.setOnTouchListener { it, _ ->
        if (it !is EditText) {
            it.hideKeyboard()
            hideSoftKeyboard()
        }
        false
    }
}