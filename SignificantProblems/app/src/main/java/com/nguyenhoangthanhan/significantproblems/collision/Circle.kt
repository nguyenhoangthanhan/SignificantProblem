package com.nguyenhoangthanhan.significantproblems.collision

import android.util.Log
import kotlin.math.sqrt

class Circle(var x: Float, var y: Float, var r: Float) {

    fun contains(xInput: Float, yInput: Float): Boolean {
        val distance = distanceToPoint(xInput.toDouble(), yInput.toDouble())
        Log.d("NHTA_CustomViewCircle", "distance = $distance and radius = $r")
        return distance < r
    }

    fun distanceToPoint(xInput: Double, yInput: Double): Double{
        return sqrt((xInput - x) * (xInput - x) + (yInput - y) * (yInput - y))
    }

    fun offsetTo(x: Float, y: Float) {
        this.x = x
        this.y = y
    }
}