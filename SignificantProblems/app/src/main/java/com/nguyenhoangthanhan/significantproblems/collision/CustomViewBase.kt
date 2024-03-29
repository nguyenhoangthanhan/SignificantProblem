package com.nguyenhoangthanhan.significantproblems.collision

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomViewBase(context: Context): View(context) {

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.GREEN)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply {
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    Log.d("NHTA _COLLISION", "down at $x $y")
                    return true
                }
                MotionEvent.ACTION_MOVE -> {
                    Log.d("NHTA_COLLISION", "move at $x $y")
                    return true
                }
                else -> {
                    return false
                }
            }
        }
        return false
    }

}