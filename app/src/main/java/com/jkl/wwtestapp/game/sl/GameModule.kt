package com.jkl.wwtestapp.game.sl

import com.jkl.wwtestapp.game.presentation.GameViewModel
import com.jkl.wwtestapp.main.sl.Core
import com.jkl.wwtestapp.main.sl.Module

class GameModule(private val core: Core) : Module<GameViewModel.Base> {
    override fun viewModel(): GameViewModel.Base =
        GameViewModel.Base(core.provideNavigation(), core.provideScoreDetails())
}