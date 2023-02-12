package com.example.androidwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.elevation.SurfaceColors

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val color = SurfaceColors.SURFACE_2.getColor(this)
        window.statusBarColor = color // Set color of system statusBar same as ActionBar
        window.navigationBarColor = color // Set color of system navigationBar same as BottomNavigationView
    }
}