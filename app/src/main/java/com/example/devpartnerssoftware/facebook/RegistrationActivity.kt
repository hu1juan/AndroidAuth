package com.example.devpartnerssoftware.facebook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registration.*
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.sdk25.coroutines.onClick

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }
}
