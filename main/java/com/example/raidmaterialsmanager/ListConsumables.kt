package com.example.raidmaterialsmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_consumables.*

class ListConsumables : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_consumables)

        cauldronData.text=intent.getStringExtra("cauldron")
        feastsData.text=intent.getStringExtra("feasts")
        elementalChaosData.text=intent.getStringExtra("chaos")
        glacialFuryData.text=intent.getStringExtra("fury")
        howlingRuneData.text=intent.getStringExtra("howling")
        rocketsData.text=intent.getStringExtra("rockets")
        buzzingRuneData.text=intent.getStringExtra("buzzing")


        btn_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}