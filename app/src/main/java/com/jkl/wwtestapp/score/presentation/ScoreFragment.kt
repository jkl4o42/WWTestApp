package com.jkl.wwtestapp.score.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.jkl.wwtestapp.R
import com.jkl.wwtestapp.main.presentation.BaseFragment

class ScoreFragment : BaseFragment<ScoreViewModel.Base>() {
    override val viewModelClass: Class<ScoreViewModel.Base> = ScoreViewModel.Base::class.java
    override val layoutId: Int = R.layout.fragment_score

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val playAgainButton = view.findViewById<Button>(R.id.button_pay_again)
        val scoreTextView = view.findViewById<TextView>(R.id.text_view_score)

        scoreTextView.text = "Score: ${viewModel.read()}"

        playAgainButton.setOnClickListener {
            viewModel.showTitle()
        }
    }
}