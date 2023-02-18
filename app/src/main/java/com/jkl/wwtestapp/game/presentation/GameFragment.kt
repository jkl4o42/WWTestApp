package com.jkl.wwtestapp.game.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.jkl.wwtestapp.R
import com.jkl.wwtestapp.main.presentation.BaseFragment

class GameFragment : BaseFragment<GameViewModel.Base>() {

    override val viewModelClass: Class<GameViewModel.Base> = GameViewModel.Base::class.java
    override val layoutId: Int = R.layout.fragment_game

    private lateinit var currentShape: Shape
    private lateinit var shapeImageView: ImageView
    private lateinit var scoreTextView: TextView
    private var score = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shapeImageView = view.findViewById(R.id.shape_image_view)
        scoreTextView = view.findViewById<Button>(R.id.text_score)
        val circleButton = view.findViewById<Button>(R.id.circle_button)
        val squareButton = view.findViewById<Button>(R.id.square_button)
        val triangleButton = view.findViewById<Button>(R.id.triangle_button)

        val shape = Shape.createRandomShape()
        currentShape = shape
        setShapeImage(shape, shapeImageView)

        circleButton.setOnClickListener { onShapeButtonClicked(ShapeType.CIRCLE) }
        squareButton.setOnClickListener { onShapeButtonClicked(ShapeType.SQUARE) }
        triangleButton.setOnClickListener { onShapeButtonClicked(ShapeType.TRIANGLE) }
    }

    private fun setShapeImage(shape: Shape, imageView: ImageView) {
        val resId = shape.getDrawable()
        imageView.setImageResource(resId)
    }

    private fun onShapeButtonClicked(shapeType: ShapeType) {
        if (shapeType == currentShape.type) {
            val shape = Shape.createRandomShape()
            currentShape = shape
            setShapeImage(shape, shapeImageView)
            score++
            scoreTextView.text = "Score: $score"
        } else {
            viewModel.save(score)
            viewModel.showScoreFragment()
        }
    }
}
