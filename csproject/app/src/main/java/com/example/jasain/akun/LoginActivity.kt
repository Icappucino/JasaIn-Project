package com.example.jasain.akun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.jasain.R
import com.example.jasain.dashboard.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buatAkun= findViewById<TextView>(R.id.tv_toregist)
        buatAkun.setOnClickListener{
            Intent(applicationContext, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}