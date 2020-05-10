package jp.making.felix.animalpreview.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import jp.making.felix.animalpreview.R
import jp.making.felix.animalpreview.viewModel.HomeViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.accessTest()
    }
}