package com.example.devpartnerssoftware.facebook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.devpartnerssoftware.facebook.util.SessionStore
import kotlinx.android.synthetic.main.activity_newsfeed.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.cancelButton
import org.jetbrains.anko.okButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class NewsfeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newsfeed)

        logoutButton.onClick {
            alert("Are you sure you want to log out?", "Info") {
                okButton {
                    SessionStore().clearEmail(this@NewsfeedActivity)
                    startActivity<SplashActivity>()
                    finish()
                }
                cancelButton {
                    return@cancelButton
                }
            }.show()
        }
    }
}
