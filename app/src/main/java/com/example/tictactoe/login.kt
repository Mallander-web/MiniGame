package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login1.*

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //Zurück zur HomePage
        val actionBar = supportActionBar
        actionBar!!.title = "TictacToe"
        actionBar.setDisplayHomeAsUpEnabled(true)

        //handle button click

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login1)
        spielenbt.setOnClickListener{

            val sp1 = findViewById<EditText>(R.id.sp1)
            val sp2 = findViewById<EditText>(R.id.sp2)


            val spieler1 = sp1.text.toString()
            val spieler2 = sp2.text.toString()

            //intent to start activity
            val intent = Intent(this@login, MainActivity::class.java)
            intent.putExtra("Spieler 1", spieler1)
            intent.putExtra("Spieler 2", spieler2)

            startActivity(intent)
        }


    }


}