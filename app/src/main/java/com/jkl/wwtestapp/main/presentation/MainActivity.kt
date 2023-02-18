package com.jkl.wwtestapp.main.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.jkl.wwtestapp.R
import com.jkl.wwtestapp.main.sl.ProvideViewModel
import com.jkl.wwtestapp.main.sl.WWTestApp

class MainActivity : AppCompatActivity(), ProvideViewModel {
    override fun onCreate(savedInstanceState: Bundle?) {
        var keepSplashOnScreen = true
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { keepSplashOnScreen }
        setContentView(R.layout.activity_main)

        val viewModel = provideViewModel(MainViewModel.Base::class.java, this)

        viewModel.observe(this) { strategy ->
            strategy.navigate(supportFragmentManager, R.id.container)
        }

        viewModel.observeConfig(this) {
            Handler(Looper.getMainLooper()).postDelayed({ keepSplashOnScreen = false }, 0)
            val isLaunch = (application as WWTestApp).launchWebView()
            viewModel.showFragment(it, isLaunch)
        }

        viewModel.fetchConfig()
    }

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T =
        (application as ProvideViewModel).provideViewModel(clazz, owner)
}