package jp.making.felix.animalpreview.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import jp.making.felix.animalpreview.R
import jp.making.felix.animalpreview.controller.HomeController
import jp.making.felix.animalpreview.databinding.FragmentHomeBinding
import jp.making.felix.animalpreview.viewModel.HomeViewModel

@ExperimentalStdlibApi
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by activityViewModels()
    lateinit var binding: FragmentHomeBinding
    lateinit var controller: HomeController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        controller = HomeController()
        binding.recyclerView.also {
            it.setController(controller)
        }
        loadDog()
    }

    private fun loadDog() {
        controller.setData(viewModel.loadDogs())
    }
}