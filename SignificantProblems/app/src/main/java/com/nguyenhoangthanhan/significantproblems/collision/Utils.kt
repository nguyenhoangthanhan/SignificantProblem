package com.nguyenhoangthanhan.significantproblems.collision

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

fun areColliding(rect: RectF, x: Float, y: Float) : Boolean =
    x >= rect.left && x <= rect.right && y >= rect.top && y <= rect.bottom

fun intersect(rect1: RectF, rect2: RectF): Boolean =
    rect1.left <= rect2.right && rect1.right >= rect2.left
            && rect1.top <= rect2.bottom && rect1.bottom >= rect2.top

fun Canvas.drawCircle(circle: Circle, paint: Paint){
    drawCircle(circle.x, circle.y, circle.r, paint)
}