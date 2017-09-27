package com.example.devpartnerssoftware.facebook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Patterns
import com.example.devpartnerssoftware.facebook.util.SessionStore
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.email
import org.jetbrains.anko.okButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        loginButton.onClick {
            val user = usernameEdit.text.toString()
            val pass = passwordEdit.text.toString()

            validate(user,pass)
        }

        signupText.onClick {
            startActivity<RegistrationActivity>()
            finish()
        }
    }

    private fun validate(user: String, pass: String){

        if(user.isEmpty()){
            alert("Please provide Email", "Error"){
                okButton { return@okButton }
            }.show()
        }else{
            if(pass.isEmpty()){
                alert("Please provide password", "Error"){
                    okButton { return@okButton }
                }.show()
            }else{
                if(!Patterns.EMAIL_ADDRESS.matcher(user).matches()){
                    alert("Invalid Email Format", "Error"){
                        okButton { return@okButton }
                    }.show()
                }else{
                    if (user.equals("johnjeffritz@gmail.com")
                            && pass.equals("juantamad")){
                        startActivity<NewsfeedActivity>()
                        val loginAuth = SessionStore()
                        loginAuth.saveEmail(user,this)
                        finish()
                    }else{
                        alert("Account not found","Error"){
                            okButton { return@okButton }
                        }.show()
                    }
                }
            }
        }
    }
}
