package com.jkl.wwtestapp.title.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.jkl.wwtestapp.main.presentation.Communication
import com.jkl.wwtestapp.main.presentation.NavigationCommunication
import com.jkl.wwtestapp.main.presentation.NavigationStrategy
import com.jkl.wwtestapp.main.presentation.Screen

interface TitleViewModel {

    fun startGame()

    class Base(
        private val navigationCommunication: NavigationCommunication.Mutable
    ) : ViewModel(), TitleViewModel {

        override fun startGame() {
            navigationCommunication.map(NavigationStrategy.Add(Screen.Game))
        }
    }
}