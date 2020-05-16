package jp.making.felix.animalpreview.controller

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import com.bumptech.glide.Glide
import jp.making.felix.animalpreview.R

@BindingAdapter("imageUrl")
fun ImageView.loadImageByUrl(imageUrl: String) {
    Log.d("URL", imageUrl)
    Glide
        .with(this)
        .load(imageUrl)
        .error(R.mipmap.ic_launcher)
        .into(this)
}