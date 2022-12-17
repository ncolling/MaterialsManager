package com.example.raidmaterialsmanager

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_consumables.btn_home
import kotlinx.android.synthetic.main.activity_raid_composition.*


class RaidComposition : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raid_composition)

        val pref = getPreferences(Context.MODE_PRIVATE)
        val prefHours = pref.getString("Hours","9")
        hoursData.setText(prefHours)
        val prefHealers = pref.getString("Healers","5")
        healerData.setText(prefHealers)
        val prefCasters = pref.getString("Casters","5")
        casterData.setText(prefCasters)
        val prefRanged = pref.getString("Ranged","2")
        rangedData.setText(prefRanged)
        val prefAgiDps = pref.getString("AgiDps","3")
        meleeAgiData.setText(prefAgiDps)
        val prefOneHStr = pref.getString("OneHStr","1")
        oneHStrData.setText(prefOneHStr)
        val prefTwoHStr = pref.getString("TwoHStr","2")
        twoHStrData.setText(prefTwoHStr)
        val prefStrTank = pref.getString("StrTank","2")
        strTankData.setText(prefStrTank)
        val prefAgiTank = pref.getString("AgiTank","0")
        agiTankData.setText(prefAgiTank)


        btn_resetdefaults.setOnClickListener {
            val defaultPref = getPreferences(Context.MODE_PRIVATE)
            val defaultEditor = defaultPref.edit()
            defaultEditor.clear()
            defaultEditor.apply()
            hoursData.setText("9")
            healerData.setText("5")
            casterData.setText("5")
            rangedData.setText("2")
            meleeAgiData.setText("3")
            oneHStrData.setText("1")
            twoHStrData.setText("2")
            strTankData.setText("2")
            agiTankData.setText("0")
        }
        btn_listconsumables.setOnClickListener {
            val intent = Intent(this, ListConsumables::class.java)

            val prefOne = getPreferences(Context.MODE_PRIVATE)
            val editor = prefOne.edit()

            val hours = Integer.parseInt(hoursData.text.toString())
            val healers = Integer.parseInt(healerData.text.toString())
            val casters = Integer.parseInt(casterData.text.toString())
            val ranged = Integer.parseInt(rangedData.text.toString())
            val agiDps = Integer.parseInt(meleeAgiData.text.toString())
            val oneHStr = Integer.parseInt(oneHStrData.text.toString())
            val twoHStr = Integer.parseInt(twoHStrData.text.toString())
            val strTank = Integer.parseInt(strTankData.text.toString())
            val agiTank = Integer.parseInt(agiTankData.text.toString())

            editor.putString("Hours",hoursData.text.toString())
            editor.putString("Healers",healerData.text.toString())
            editor.putString("Casters",casterData.text.toString())
            editor.putString("Ranged",rangedData.text.toString())
            editor.putString("AgiDps",meleeAgiData.text.toString())
            editor.putString("OneHStr",oneHStrData.text.toString())
            editor.putString("TwoHStr",twoHStrData.text.toString())
            editor.putString("StrTank",strTankData.text.toString())
            editor.putString("AgiTank",agiTankData.text.toString())
            editor.apply()

            val cauldron = hours/3
            val feasts:Int = 10*hours
            val phialChaos:Int = 2*hours*(healers+casters+ranged)
            val phialFury:Int = 2*hours*(agiDps+oneHStr+twoHStr+strTank+agiTank)
            val howling:Int = hours*(casters+healers)
            val rockets:Int = hours*ranged
            val buzzing:Int = hours*(agiDps*2 + oneHStr + twoHStr*2 + strTank + agiTank*2)

            intent.putExtra("cauldron",cauldron.toString())
            intent.putExtra("feasts",feasts.toString())
            intent.putExtra("chaos",phialChaos.toString())
            intent.putExtra("fury",phialFury.toString())
            intent.putExtra("howling",howling.toString())
            intent.putExtra("rockets",rockets.toString())
            intent.putExtra("buzzing",buzzing.toString())

            startActivity(intent)
        }


    }
}

