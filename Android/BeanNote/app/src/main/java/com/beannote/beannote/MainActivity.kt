package com.beannote.beannote

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.beannote.beannote.user.LoginAty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sample_text.setOnClickListener {
            var intent = Intent(this@MainActivity, LoginAty::class.java)
            startActivity(intent)
        }
    }


}
