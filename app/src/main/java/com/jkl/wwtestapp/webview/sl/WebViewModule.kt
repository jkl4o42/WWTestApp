package com.jkl.wwtestapp.webview.sl

import com.jkl.wwtestapp.main.sl.Module
import com.jkl.wwtestapp.webview.presentation.WebViewViewModel

class WebViewModule : Module<WebViewViewModel> {
    override fun viewModel(): WebViewViewModel =
        WebViewViewModel()
}