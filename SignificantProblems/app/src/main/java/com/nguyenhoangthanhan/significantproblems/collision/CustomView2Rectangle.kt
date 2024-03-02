package com.nguyenhoangthanhan.significantproblems.collision

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomView2(context: Context): View(context) {

    val rect1 = RectF(100f, 100f, 300f, 300f)
    val rect2 = RectF(100f,400f, 400f, 600f)
    var selectedRect: RectF? = null

    val rect = RectF(
        100f, // left
        100f, // top
        500f, // right
        500f, // bottom
    )

    val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 8f
    }

    var collision = intersect(rect1, rect2)

//    var collision = false

    override fun onDraw(canvas: Canvas) {
        canvas.apply {
//            if (collision){
//                drawColor(Color.RED)
//            }else {
//                drawColor(Color.GREEN)
//            }
//            drawRect(rect, paint)
            if (collision){
                drawColor(Color.RED)
            }else {
                drawColor(Color.GREEN)
            }
            drawRect(rect1, paint)
            drawRect(rect2, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply {
            when(action){
                MotionEvent.ACTION_DOWN -> {
//                    collision = rect.contains(x, y)
//                    collision = areColliding(rect, x, y)
//                    invalidate()

                    selectedRect = when{
                        rect1.contains(x, y) -> rect1
                        rect2.contains(x, y) -> rect2
                        else -> null
                    }
                    Log.d("NHTA _COLLISION", "down at $x $y")
                    return true
                }
                MotionEvent.ACTION_MOVE -> {
                    when(selectedRect){
                        rect1 -> rect1.offsetTo(x, y)
                        rect2 -> rect2.offsetTo(x, y)
                        else -> return true
                    }
                    collision = intersect(rect1, rect2)
                    invalidate()
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