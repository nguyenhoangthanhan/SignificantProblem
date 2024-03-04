package com.nguyenhoangthanhan.significantproblems.mazegame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View

class GameView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.GREEN)
    }

    inner class Cell(colInput: Int, rowInput: Int) {
        val topWall = true
        val leftWall = true
        val bottomWall = true
        val rightWall = true

        var col: Int = colInput
        var row: Int = rowInput

    }
}