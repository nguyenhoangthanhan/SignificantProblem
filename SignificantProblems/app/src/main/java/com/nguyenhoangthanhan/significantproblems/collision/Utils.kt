package com.nguyenhoangthanhan.significantproblems.collision

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

fun areColliding(rect: RectF, x: Float, y: Float): Boolean =
    x >= rect.left && x <= rect.right && y >= rect.top && y <= rect.bottom

fun intersect(rect1: RectF, rect2: RectF): Boolean =
    rect1.left <= rect2.right && rect1.right >= rect2.left
            && rect1.top <= rect2.bottom && rect1.bottom >= rect2.top

fun Canvas.drawCircle(circle: Circle, paint: Paint) {
    drawCircle(circle.x, circle.y, circle.r, paint)
}

fun intersectCircleAndRectangular(circle: Circle, rect: RectF): Boolean {
    val xDistance = Math.abs(rect.centerX() - circle.x)
    val yDistance = Math.abs(rect.centerY() - circle.y)

    val halfWidth = rect.width() / 2
    val halfHeight = rect.height() / 2

    if (xDistance > halfWidth + circle.r) return false
    if (yDistance > halfHeight + circle.r) return false

    if (xDistance <= halfWidth) return true
    if (yDistance <= halfHeight) return true

    //if rect.contains(circle.x, circle.y) return true
    val cornerDistance_sq = sqrt(
        (xDistance - rect.width() / 2) * (xDistance - rect.width() / 2) +
                (yDistance - rect.height() / 2) * (yDistance - rect.height() / 2)
    )
    return cornerDistance_sq <= circle.r
}

fun Canvas.drawLine(line: Line, paint: Paint) =
    line.run {
        drawLine(start.x, start.y, end.x, end.y, paint)
    }

fun PointF.isInDistanceOf(x: Float, y: Float, maxDistance: Float): Boolean{
    val xDistance = this.x - x // x - this.x
    val yDistance = this.y - y

    val squaredDistance = xDistance * xDistance + yDistance * yDistance

    return squaredDistance <= maxDistance * maxDistance
}

fun Float.isBetween(num1: Float, num2: Float) =
    min(num1, num2) <= this && this <= max(num1, num2)