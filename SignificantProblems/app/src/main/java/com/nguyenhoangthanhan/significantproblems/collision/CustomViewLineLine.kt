package com.nguyenhoangthanhan.significantproblems.collision

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomViewLineLine(context: Context) : View(context) {

    val touchRadius = 40f

    val scale = context.resources.displayMetrics.density

    val touchRadiusPx = touchRadius * scale

    /**
     * medium pixel density: scale = 1px/dp
     * touchRadiusPX = 40dp* 1px/dp = 40px
     * higher pixel density: scale = 1.5px/dp
     * touchRadiusPX = 40dp * 1.5px/dp = 60px
     */
    val points = listOf(
        PointF(0f, 0f), //line1.start
        PointF(500f, 500f), // line1.end
        PointF(500f, 0f), // line2.start
        PointF(0f, 500f) // line2.end
    )

    val line1 = Line(points[0], points[1])
    val line2 = Line(points[2], points[3])

    var selectedPoint: PointF? = null

    var collision = line1.intersects(line2)

    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        strokeWidth = 8f
    }

    override fun onDraw(canvas: Canvas) {
        canvas.apply {
            if (collision)
                drawColor(Color.RED)
            else
                drawColor(Color.GREEN)
            drawLine(line1, paint = paint)
            drawLine(line2, paint = paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply {
            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    Log.d("NHTA _COLLISION", "down at $x $y")
                    selectedPoint = points.find{it.isInDistanceOf(x, y, touchRadiusPx)}
                    return true
                }

                MotionEvent.ACTION_MOVE -> {
                    Log.d("NHTA_COLLISION", "move at $x $y")
                    selectedPoint?.set(x, y)
                    collision = line1.intersects(line2)
                    invalidate()
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