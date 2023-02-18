package com.jkl.wwtestapp.title.sl

import com.jkl.wwtestapp.main.sl.Module
import com.jkl.wwtestapp.main.sl.ProvideNavigation
import com.jkl.wwtestapp.title.presentation.TitleViewModel

class TitleModule(private val provideNavigation: ProvideNavigation) : Module<TitleViewModel.Base> {
    override fun viewModel(): TitleViewModel.Base =
        TitleViewModel.Base(provideNavigation.provideNavigation())
}