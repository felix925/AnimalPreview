package jp.making.felix.animalpreview.controller

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import jp.making.felix.animalpreview.R
import kotlinx.coroutines.withContext

@BindingAdapter("imageUrl")
fun ImageView.loadImageByUrl(imageUrl: String) {
    Log.d("url", imageUrl)
    this.load(imageUrl){
        placeholder(R.drawable.ic_launcher_background)
    }
}