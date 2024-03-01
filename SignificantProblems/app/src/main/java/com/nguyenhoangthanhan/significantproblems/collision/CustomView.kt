package com.nguyenhoangthanhan.significantproblems.collision

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomView(context: Context): View(context) {

    val rect = RectF(
        100f, // left
        100f, // top
        500f, // right
        500f, // bottom
    )

    val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 4f
    }

    var collision = false

    override fun onDraw(canvas: Canvas) {
        canvas.apply {
            if (collision){
                drawColor(Color.RED)
            }else {
                drawColor(Color.GREEN)
            }
            drawRect(rect, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply {
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    collision = rect.contains(x, y)
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