package com.example.raidmaterialsmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_raidcomp.setOnClickListener {
            val intent = Intent(this, RaidComposition::class.java)
            startActivity(intent)
        }

        btn_help.setOnClickListener {
            val intent = Intent(this, Help::class.java)
            startActivity(intent)
        }
    }
}