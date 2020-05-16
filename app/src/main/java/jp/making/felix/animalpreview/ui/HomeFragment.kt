package jp.making.felix.animalpreview.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import jp.making.felix.animalpreview.R
import jp.making.felix.animalpreview.controller.HomeController
import jp.making.felix.animalpreview.data.repository.DogRepository
import jp.making.felix.animalpreview.data.response.DogApiService
import jp.making.felix.animalpreview.data.response.DogDataSource
import jp.making.felix.animalpreview.databinding.FragmentHomeBinding
import jp.making.felix.animalpreview.viewModel.HomeViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@ExperimentalStdlibApi
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by activityViewModels()
    lateinit var binding: FragmentHomeBinding
    lateinit var controller: HomeController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controller = HomeController()
        binding = FragmentHomeBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerView.also {
            it.setController(controller)
        }
        // 上からスワイプした時の動作
        binding.swipeRefresh.apply {
            setOnRefreshListener {
                viewModel.loadDogs()
            }
        }

        //読み込みが終了したときにデータをセットして、プログレスバーを削除する。
        viewModel.dogs.observe(this) {
            controller.setData(it)
            binding.swipeRefresh.isRefreshing = false
        }
        //初期読み込み
        viewModel.loadDogs()
    }
}