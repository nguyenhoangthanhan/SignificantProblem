package com.nguyenhoangthanhan.significantproblems.collision

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.MotionEvent
import android.view.View

class CustomView(context: Context): View(context) {

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.GREEN)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)

    }

}