package com.nguyenhoangthanhan.significantproblems

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguyenhoangthanhan.significantproblems.collision.CustomView
import com.nguyenhoangthanhan.significantproblems.collision.CustomViewCircle

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(CustomView(this))
        setContentView(CustomViewCircle(this))
    }
}