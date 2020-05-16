package jp.making.felix.animalpreview.viewModel

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.Coil
import coil.api.load
import jp.making.felix.animalpreview.data.repository.DogRepository
import jp.making.felix.animalpreview.data.response.DogDataSource
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {
    private val _dogs: MutableLiveData<List<Pair<String, Boolean>>> = MutableLiveData()
    val dogs: LiveData<List<Pair<String, Boolean>>> get() = _dogs
    @ExperimentalStdlibApi
    private val dogDataSource: DogDataSource = DogRepository()

    @ExperimentalStdlibApi
    fun loadDogs() {
        // TODO: DataSourceをInjectできるようにしてそこから値を使う
        // TODO: いいね的な機能を実装する DBを整える必要性が出てくる Url,FabState
        val imageList = listOf(
            "https://images.dog.ceo/breeds/pomeranian/n02112018_354.jpg" to true,
            "https://images.dog.ceo/breeds/appenzeller/n02107908_3155.jpg" to true,
            "https://images.dog.ceo/breeds/setter-gordon/n02101006_2501.jpg" to true,
            "https://images.dog.ceo/breeds/terrier-american/n02093428_1439.jpg" to true,
            "https://images.dog.ceo/breeds/papillon/n02086910_7842.jpg" to true,
            "https://images.dog.ceo/breeds/terrier-lakeland/n02095570_2872.jpg" to true
        )
//        _dogs.value = imageList
        viewModelScope.launch {
            val list = dogDataSource.getDogs(10)
            _dogs.value = buildList {
                list.forEach {
                    this.add(Pair(it.url,true))
                }
            }
        }
    }
}