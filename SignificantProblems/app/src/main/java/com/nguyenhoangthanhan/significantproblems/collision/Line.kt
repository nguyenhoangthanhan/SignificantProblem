package com.nguyenhoangthanhan.significantproblems.collision

import android.graphics.PointF

class Line(val start: PointF, val end: PointF) {

    fun intersects(other: Line): Boolean{
        val x1 = start.x
        val y1 = start.y
        val x2 = end.x
        val y2 = end.y
        val x3 = other.start.x
        val y3 = other.start.y
        val x4 = other.end.x
        val y4 = other.end.y
        /**
         * vector equation for line p1 p2
         * p = p1 + u * ( p2 - p1 )
         * u = 0: p = p1
         * u = 1: p = p1 + p2 - p1 = p2
         * u = 0.5: p = midpoint between p1 p2
         *
         * for this line
         * x = x1 + ut * ( x2 - x1 )
         * y = y1 + ut * ( y2 - y1 )
         * for other line
         * x = x3 + uo * ( x4 - x3 )
         * y = y3 + uo * ( y4 - y3 )
         *
         * x1 + ut * ( x2 - x1 ) = x3 + uo * ( x4 - x3 )
         * y1 + ut * ( y2 - y1 ) = y3 + uo * ( y4 - y3 )
         *
         * ut * ( x2 - x1 ) + uo * ( x3 - x4 ) = x3 - x1
         * ut * ( y2 - y1 ) - uo * ( y3 - y4 ) = y3 - y1
         *
         * ut * ax + uo * bx = cx
         * ut * ay + uo * by = cy
         */
        val ax = x2 - x1
        val ay = y2 - y1
        val bx = x3 - x4
        val by = y3 - y4
        val cx = x3 - x1
        val cy = y3 - y1

        /**
         *      |cx bx|       |ax cx|
         *      |cy by|       |ay cy|
         * ut = -------, uo = -------
         *      |ax bx|       |ax bx|
         *      |ay by|       |ay by|
         *
         */

        val denominator = ax * by - bx * ay
        val numerator = cx * by - cy * bx
        val otherNumerator = ax * cy - cx * ay
        if (denominator == 0f){
            // lines are parallel

            if (numerator == 0f){
                //lines are collinear

                return x1.isBetween(x3, x4) || x2.isBetween(x3, x4) ||
                        x3.isBetween(x1, x2) || x4.isBetween(x1, x2)
            }

            return false
        }

        val ut = numerator / denominator
        val uo = otherNumerator / denominator

        return ut in 0.0..1.0 && uo in 0.0..1.0
    }
}