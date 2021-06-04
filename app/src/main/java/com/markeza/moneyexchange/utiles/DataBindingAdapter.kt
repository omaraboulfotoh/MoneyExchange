package com.markeza.moneyexchange.utiles

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.markeza.moneyexchange.R
import com.markeza.moneyexchange.app.MEDIA_URL
import com.squareup.picasso.Picasso


@BindingAdapter("imageUrl")
fun ImageView.loadImage(imageUrl: String) {
    if (imageUrl.isNotEmpty())
        Picasso.get()
            .load(MEDIA_URL + imageUrl)
            .placeholder(R.mipmap.ic_launcher)
            .into(this)
    else
        this.setImageResource(R.mipmap.ic_launcher)
}

@BindingAdapter("android:setTitle")
fun TextView.text(text: String) {
    this.text = text.replace("&amp;", "&")
}