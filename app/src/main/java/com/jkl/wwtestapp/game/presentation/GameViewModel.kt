package com.jkl.wwtestapp.game.presentation

import androidx.lifecycle.ViewModel
import com.jkl.wwtestapp.main.presentation.NavigationCommunication
import com.jkl.wwtestapp.main.presentation.NavigationStrategy
import com.jkl.wwtestapp.main.presentation.Screen
import com.jkl.wwtestapp.score.data.ScoreDetails

interface GameViewModel {
    fun showScoreFragment()

    class Base(
        private val navigationCommunication: NavigationCommunication.Mutable,
        private val scoreDetails: ScoreDetails.Save
    ) : ViewModel(), GameViewModel, ScoreDetails.Save {

        override fun showScoreFragment() {
            navigationCommunication.map(NavigationStrategy.Replace(Screen.Score))
        }

        override fun save(data: Int) {
            scoreDetails.save(data)
        }
    }
}

