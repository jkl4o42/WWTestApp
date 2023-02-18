package com.jkl.wwtestapp.game.presentation

import com.jkl.wwtestapp.R
import java.util.*

data class Shape(val type: ShapeType, val color: Int) {
    fun getDrawable(): Int {
        val drawableResId = when (type) {
            ShapeType.CIRCLE -> R.drawable.circle
            ShapeType.SQUARE -> R.drawable.square
            ShapeType.TRIANGLE -> R.drawable.triangle
        }
        return drawableResId
    }

    companion object {
        private val random = Random(System.currentTimeMillis())

        fun createRandomShape(): Shape {
            val type = ShapeType.values()[random.nextInt(ShapeType.values().size)]
            val color = getRandomColor()
            return Shape(type, color)
        }

        fun getRandomColor(): Int {
            val colors = listOf(
                android.R.color.holo_red_dark,
                android.R.color.holo_blue_dark,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_purple
            )
            return colors[random.nextInt(colors.size)]
        }
    }
}

enum class ShapeType {
    CIRCLE,
    SQUARE,
    TRIANGLE
}