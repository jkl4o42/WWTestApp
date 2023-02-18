package com.jkl.wwtestapp.main.sl

import android.content.Context
import android.content.SharedPreferences
import com.jkl.wwtestapp.main.presentation.NavigationCommunication
import com.jkl.wwtestapp.score.data.ScoreDetails

interface Core : ProvideNavigation, ProvideSharedPreference, ProvideScoreDetails {

    class Base(
        context: Context
    ) : Core {

        private val scoreDetails = ScoreDetails.Base()

        private val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("config", Context.MODE_PRIVATE)

        private val navigationCommunication = NavigationCommunication.Base()

        override fun provideNavigation(): NavigationCommunication.Mutable = navigationCommunication

        override fun provideSharedPref(): SharedPreferences = sharedPreferences

        override fun provideScoreDetails(): ScoreDetails.Mutable = scoreDetails
    }
}

interface ProvideNavigation {
    fun provideNavigation(): NavigationCommunication.Mutable
}

interface ProvideSharedPreference {
    fun provideSharedPref(): SharedPreferences
}

interface ProvideScoreDetails {
    fun provideScoreDetails(): ScoreDetails.Mutable
}