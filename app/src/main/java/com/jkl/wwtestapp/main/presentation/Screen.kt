package com.jkl.wwtestapp.main.presentation

import com.jkl.wwtestapp.game.presentation.GameFragment
import com.jkl.wwtestapp.score.presentation.ScoreFragment
import com.jkl.wwtestapp.title.presentation.TitleFragment
import com.jkl.wwtestapp.webview.presentation.WebViewFragment

sealed class Screen {
    abstract fun fragment(): Class<out BaseFragment<*>>

    object WebView : Screen() {
        override fun fragment(): Class<out BaseFragment<*>> = WebViewFragment::class.java
    }

    object Title : Screen() {
        override fun fragment(): Class<out BaseFragment<*>> = TitleFragment::class.java
    }

    object Game : Screen() {
        override fun fragment(): Class<out BaseFragment<*>> = GameFragment::class.java
    }

    object Score : Screen() {
        override fun fragment(): Class<out BaseFragment<*>> = ScoreFragment::class.java
    }
}