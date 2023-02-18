package com.jkl.wwtestapp.score.sl

import com.jkl.wwtestapp.main.sl.Core
import com.jkl.wwtestapp.main.sl.Module
import com.jkl.wwtestapp.score.presentation.ScoreViewModel

class ScoreModule(private val core: Core) : Module<ScoreViewModel.Base> {
    override fun viewModel(): ScoreViewModel.Base =
        ScoreViewModel.Base(core.provideNavigation(), core.provideScoreDetails())
}