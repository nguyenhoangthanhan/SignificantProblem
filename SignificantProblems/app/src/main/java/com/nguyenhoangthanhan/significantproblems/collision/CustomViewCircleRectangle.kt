package com.nguyenhoangthanhan.significantproblems.collision

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomViewCircleRectangle(context: Context): View(context) {

    val circle = Circle(100f, 200f, 100f)

    val rect = RectF(300f, 400f, 500f, 700f)

    var selectedObject: Any? = null

    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 8f
    }

    var collisionBwtCircleAndRect = false

    override fun onDraw(canvas: Canvas) {
        canvas.apply {
            if (collisionBwtCircleAndRect)
                drawColor(Color.RED)
            else drawColor(Color.GREEN)
            drawCircle(circle, paint)
            drawRect(rect, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply {
            when(action){
                MotionEvent.ACTION_DOWN -> {
//                    collisionBwtCircleAndRect = circle.contains(x, y)
                    selectedObject = when{
                        rect.contains(x, y) -> rect
                        circle.contains(x, y) -> circle
                        else -> null
                    }
//                    invalidate()
                    Log.d("NHTA _COLLISION", "down at $x $y")
                    return true
                }
                MotionEvent.ACTION_MOVE -> {
                    when(selectedObject){
                        rect -> rect.offsetTo(x, y)
                        circle -> circle.offsetTo(x, y)
                    }

                    collisionBwtCircleAndRect = intersectCircleAndRectangular(circle, rect)

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