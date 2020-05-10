package jp.making.felix.animalpreview.viewModel

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {
    fun accessTest() {
        Log.d("Access","SUCCESS!!!")
    }
}