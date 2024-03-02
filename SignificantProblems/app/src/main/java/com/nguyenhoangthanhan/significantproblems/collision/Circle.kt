package com.nguyenhoangthanhan.significantproblems.collision

import android.util.Log
import kotlin.math.sqrt

class Circle(var x: Float, var y: Float, var r: Float) {

    fun contains(xInput: Float, yInput: Float): Boolean {
        val distance = sqrt((xInput - x) * (xInput - x) + (yInput - y) * (yInput - y))
        Log.d("NHTA_CustomViewCircle", "distance = $distance and radius = $r")
        return distance < r
    }
}