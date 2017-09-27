package com.example.devpartnerssoftware.facebook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.devpartnerssoftware.facebook.util.SessionStore
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler().postDelayed({
            val loginAuth = SessionStore().restoreEmail(this)
            if(loginAuth.isEmpty()){
                startActivity<LoginActivity>()
            }else{
                startActivity<NewsfeedActivity>()
            }
            finish()
        }, 3000)
    }
}
