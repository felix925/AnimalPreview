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