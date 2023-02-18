package com.jkl.wwtestapp.title.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.jkl.wwtestapp.R
import com.jkl.wwtestapp.main.presentation.BaseFragment

class TitleFragment : BaseFragment<TitleViewModel.Base>() {
    override val viewModelClass: Class<TitleViewModel.Base> = TitleViewModel.Base::class.java
    override val layoutId: Int = R.layout.fragment_title

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val startButton = view.findViewById<Button>(R.id.startButton)

        startButton.setOnClickListener {
            viewModel.startGame()
        }
    }
}