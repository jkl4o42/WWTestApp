package com.jkl.wwtestapp.main.sl

import androidx.lifecycle.ViewModel
import com.jkl.wwtestapp.game.presentation.GameViewModel
import com.jkl.wwtestapp.title.presentation.TitleViewModel
import com.jkl.wwtestapp.game.sl.GameModule
import com.jkl.wwtestapp.main.presentation.MainViewModel
import com.jkl.wwtestapp.score.presentation.ScoreViewModel
import com.jkl.wwtestapp.score.sl.ScoreModule
import com.jkl.wwtestapp.title.sl.TitleModule
import com.jkl.wwtestapp.webview.presentation.WebViewViewModel
import com.jkl.wwtestapp.webview.sl.WebViewModule

interface DependencyContainer {

    fun <T : ViewModel> module(clasz: Class<T>): Module<*>

    class Error : DependencyContainer {
        override fun <T : ViewModel> module(clasz: Class<T>): Module<*> =
            throw IllegalStateException("no module found for $clasz")
    }

    class Base(
        private val core: Core,
        private val dependencyContainer: DependencyContainer = Error()
    ) : DependencyContainer {
        override fun <T : ViewModel> module(clasz: Class<T>): Module<*> = when (clasz) {
            MainViewModel.Base::class.java -> MainModule(core)
            WebViewViewModel::class.java -> WebViewModule()
            TitleViewModel.Base::class.java -> TitleModule(core)
            GameViewModel.Base::class.java -> GameModule(core)
            ScoreViewModel.Base::class.java -> ScoreModule(core)
            else -> dependencyContainer.module(clasz)
        }
    }
}