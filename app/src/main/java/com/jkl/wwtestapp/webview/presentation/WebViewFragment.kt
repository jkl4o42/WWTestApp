package com.jkl.wwtestapp.webview.presentation

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import com.google.gson.Gson
import com.jkl.wwtestapp.R
import com.jkl.wwtestapp.main.data.ConfigData
import com.jkl.wwtestapp.main.presentation.BaseFragment
import com.jkl.wwtestapp.main.sl.WWTestApp

class WebViewFragment : BaseFragment<WebViewViewModel>() {

    override val layoutId: Int = R.layout.fragment_webview
    override val viewModelClass: Class<WebViewViewModel> = WebViewViewModel::class.java

    private lateinit var webView: WebView

    private val backPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (webView.canGoBack()) {
                webView.goBack()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(backPressedCallback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        val sharedPreferences =
            requireActivity().getSharedPreferences("config", Context.MODE_PRIVATE)
        sharedPreferences?.let { shared ->
            val link = shared.getString("link", "") ?: ""
            if (link.isNotEmpty()) {
                webView.loadUrl(link)
                (requireActivity().application as WWTestApp).changeLaunchWebView()
            }
        }
    }
}