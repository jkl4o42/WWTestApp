package com.jkl.wwtestapp.score.presentation

import androidx.lifecycle.ViewModel
import com.jkl.wwtestapp.main.presentation.NavigationCommunication
import com.jkl.wwtestapp.main.presentation.NavigationStrategy
import com.jkl.wwtestapp.main.presentation.Screen
import com.jkl.wwtestapp.score.data.ScoreDetails

interface ScoreViewModel {

    fun showTitle()

    class Base(
        private val navigationCommunication: NavigationCommunication.Mutable,
        private val scoreDetails: ScoreDetails.Read
    ) : ViewModel(), ScoreViewModel, ScoreDetails.Read {

        override fun showTitle() {
            navigationCommunication.map(NavigationStrategy.Replace(Screen.Title))
        }

        override fun read(): Int = scoreDetails.read()
    }
}
