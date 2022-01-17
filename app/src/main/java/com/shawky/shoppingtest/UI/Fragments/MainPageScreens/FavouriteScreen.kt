package com.shawky.shoppingtest.UI.Fragments.MainPageScreens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shawky.shoppingtest.R
import com.shawky.shoppingtest.UI.Adapters.SectionAdapter
import com.shawky.shoppingtest.databinding.FragmentFavScreenBinding

class FavouriteScreen : Fragment(R.layout.fragment_fav_screen) {

    private var binding : FragmentFavScreenBinding ?= null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFavScreenBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        binding!!.rv.apply {
            adapter = SectionAdapter(this@FavouriteScreen)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}