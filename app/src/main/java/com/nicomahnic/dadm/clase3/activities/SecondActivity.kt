package com.nicomahnic.dadm.clase3.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nicomahnic.dadm.clase3.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        getSupportActionBar()?.hide()
    }
}