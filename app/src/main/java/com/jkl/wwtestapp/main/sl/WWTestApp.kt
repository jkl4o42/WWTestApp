package com.jkl.wwtestapp.main.sl

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

class WWTestApp : Application(), ProvideViewModel {

    private lateinit var viewModelsFactory: ViewModelsFactory
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate() {
        super.onCreate()

        viewModelsFactory = ViewModelsFactory(DependencyContainer.Base(Core.Base(this)))

        sharedPref = getSharedPreferences("config", Context.MODE_PRIVATE)
    }

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T =
        ViewModelProvider(owner, viewModelsFactory)[clazz]

    fun launchWebView(): Boolean = sharedPref.getBoolean("launch_web_view", true)

    fun changeLaunchWebView() {
        sharedPref.edit().putBoolean("launch_web_view", false).apply()
    }

    fun link(): String = sharedPref.getString("link", "") ?: ""
}
