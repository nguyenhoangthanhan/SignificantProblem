package com.nguyenhoangthanhan.significantproblems.collision

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomViewTwoCircle(context: Context) : View(context) {

    val circle1 = Circle(100f, 200f, 100f)

    var circle2 = Circle(400f, 400f, 100f)

    var selectedCircle: Circle? = null

    var collisionBwt2Circle = false

    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 8f
    }

    override fun onDraw(canvas: Canvas) {
        canvas.apply {
            if (collisionBwt2Circle)
                drawColor(Color.RED)
            else drawColor(Color.GREEN)
            drawCircle(circle1, paint)
            drawCircle(circle2, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply {
            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    selectedCircle = when {
                        circle1.contains(x, y) -> circle1
                        circle2.contains(x, y) -> circle2
                        else -> null
                    }
                    Log.d("NHTA_COLLISION", "down at $x $y")
                    return true
                }

                MotionEvent.ACTION_MOVE -> {
                    when (selectedCircle) {
                        circle1 -> circle1.offsetTo(x, y)
                        circle2 -> circle2.offsetTo(x, y)
                        else -> return true
                    }
                    collisionBwt2Circle = circle1.distanceToPoint(
                            circle2.x.toDouble(),
                            circle2.y.toDouble()
                        ) < (circle1.r + circle2.r)
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