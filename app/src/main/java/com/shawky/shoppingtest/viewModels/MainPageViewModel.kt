package com.shawky.shoppingtest.viewModels

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shawky.shoppingtest.R
import com.shawky.shoppingtest.UI.Fragments.MainPageScreens.CartScreen
import com.shawky.shoppingtest.UI.Fragments.MainPageScreens.FavouriteScreen
import com.shawky.shoppingtest.UI.Fragments.MainPageScreens.HomeScreen
import com.shawky.shoppingtest.UI.Fragments.MainPageScreens.PersonScreen

class MainPageViewModel : ViewModel() {

    private val homeFragment = HomeScreen()
    private val favouriteScreen = FavouriteScreen()
    private val cartScreen = CartScreen()
    private val  personScreen = PersonScreen()

    private var activeFragment = MutableLiveData<Int>()

    val theme : MutableLiveData<Int> = MutableLiveData(R.style.Theme_ShoppingTestThemeOne)

    fun changeTheme(context: Context){
        context.setTheme(theme.value!!)
    }

    fun navigateFragment(itemId : Int , mainView : Int ,fragmentManager: FragmentManager) : Boolean{
        activeFragment.value = itemId
        val fragmentName : Fragment = when(itemId)
        {
            R.id.home ->        homeFragment
            R.id.favourite ->   favouriteScreen
            R.id.cart ->        cartScreen
            R.id.person ->      personScreen
            else ->             homeFragment
        }
        fragmentManager.beginTransaction().replace(mainView,fragmentName).commit()
        return true
    }

    fun createNewTheme(context: Context){

    }
}