package com.nicomahnic.dadm.clase3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nicomahnic.dadm.clase3.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide()
    }
}