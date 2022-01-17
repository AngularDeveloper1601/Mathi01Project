package com.example.mathi01project

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import kotlin.random.Random
import androidx.core.app.ActivityCompat
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickMeButton = findViewById<Button>(R.id.clickMeButton)
        val resultText = findViewById<TextView>(R.id.resultText)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)

        clickMeButton.setOnClickListener {
            val randomNumber = Random.nextInt(seekBar.progress)
            resultText.text = randomNumber.toString()

            val smsManager = SmsManager.getDefault()
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), 1)
            val output = StringBuilder()
            for(i in 0 until randomNumber){
                output.append("KrishnaRaj\n")
        }
            smsManager.sendTextMessage("+917305420465", null, output.toString(), null, null)
        }
    }
}