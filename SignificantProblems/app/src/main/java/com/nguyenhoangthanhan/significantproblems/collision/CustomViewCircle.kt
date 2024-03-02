package com.nguyenhoangthanhan.significantproblems.collision

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomViewCircle(context: Context): View(context) {

    val circle = Circle(400f, 400f, 200f)

    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 8f
    }

    var collision = false

    override fun onDraw(canvas: Canvas) {
        canvas.apply {
            if (!collision)
                drawColor(Color.GREEN)
            else
                drawColor(Color.RED)
            drawCircle(circle.x, circle.y, circle.r, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply {
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    collision = circle.contains(x, y)
                    invalidate()
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