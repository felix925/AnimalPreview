package jp.making.felix.animalpreview.viewModel

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import coil.Coil
import coil.api.load
import javax.inject.Inject

@ExperimentalStdlibApi
class HomeViewModel @Inject constructor() : ViewModel() {

    fun loadDogs(): List<Pair<String, Boolean>> {
        val imageList = listOf(
            "https://images.dog.ceo/breeds/pomeranian/n02112018_354.jpg" to true,
            "https://images.dog.ceo/breeds/appenzeller/n02107908_3155.jpg" to true,
            "https://images.dog.ceo/breeds/setter-gordon/n02101006_2501.jpg" to true,
            "https://images.dog.ceo/breeds/terrier-american/n02093428_1439.jpg" to true,
            "https://images.dog.ceo/breeds/papillon/n02086910_7842.jpg" to true,
            "https://images.dog.ceo/breeds/terrier-lakeland/n02095570_2872.jpg" to true
        )
        return imageList
    }
}