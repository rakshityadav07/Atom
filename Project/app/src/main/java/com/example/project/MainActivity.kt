package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        supportActionBar?.hide()

        Handler().postDelayed({
            if (user != null) {
                val homeScreenIntent = Intent(this, HomeScreen::class.java)
                startActivity(homeScreenIntent)
                finish()
            } else {
                val signInIntent = Intent(this, SignIn::class.java)
                startActivity(signInIntent)
                finish();
            }
        }, 3000)


    }

}