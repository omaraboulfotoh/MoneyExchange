package com.android.moneyexchange.utiles

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.android.moneyexchange.R
import com.android.moneyexchange.app.MEDIA_URL
import com.squareup.picasso.Picasso


@BindingAdapter("imageSrc")
fun ImageView.loadImage(imageSrc: Int) {
    Picasso.get()
        .load(imageSrc)
        .placeholder(R.mipmap.ic_launcher)
        .into(this)
}

@BindingAdapter("android:setTitle")
fun TextView.text(text: String) {
    this.text = text.replace("&amp;", "&")
}