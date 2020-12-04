package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var scorepl1 = 0
    private var scorepl2 = 0
    private var currentplayer = "x"
    private var actualplayer = ""
    private var gamestate = "playing"
    private lateinit var allFields: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Namen der Spieler anzeigen
        val intent = intent
        val spieler1 = intent.getStringExtra("Spieler 1")
        val spieler2 = intent.getStringExtra("Spieler 2")


        val textViewsp1 = findViewById<TextView>(R.id.sp1)
        textViewsp1.text = spieler1

        val textViewsp2 = findViewById<TextView>(R.id.sp2)
        textViewsp2.text = spieler2

        // Spieler 1 (x) beginnt immer
        if (spieler1 != null) {
            actualplayer = spieler1
        }
        Titelid.text = actualplayer + " (x) beginnt!"


        //zurück zur LoginPage
        val actionBar = supportActionBar
        actionBar!!.title = "TictacToe"
        actionBar.setDisplayHomeAsUpEnabled(true)

        //Alle Felder einlesen und in einem Array speichern
        allFields = arrayOf(f11, f2, f3, f4, f5, f6, f7, f8, f9)

        for(field in allFields){
            field.setOnClickListener {
                onfieldclick(it as TextView)
            }
        }
    }
    private fun onfieldclick(field : TextView){

        if (gamestate != "playing"){
            resetGame()
            return
        }

        if(field.text == "") {
            field.text = currentplayer

            if (checkwin()){


                // Score Countdown

                val intent = intent
                val spieler1 = intent.getStringExtra("Spieler 1")
                val spieler2 = intent.getStringExtra("Spieler 2")

                if (actualplayer == spieler1){
                    val score1 = findViewById<TextView>(R.id.score1)
                    scorepl1 += 1
                    score1.text = "Score: " + scorepl1

                }
                else if (actualplayer == spieler2) {
                    val score2 = findViewById<TextView>(R.id.score2)
                    scorepl2 += 1

                    score2.text = "Score: " + scorepl2
                }

                //Endergebnis anzeigen
                Titelid.text = " $actualplayer hat gewonnen!"
                gamestate = "won"

                // Unentschieden anzeigen
            } else if (allFields.all { it.text != "" }){

                gamestate = "brace"
                Titelid.text = "Unentschieden!"
            }

            else {
                //Spieler Text "actualplayer ist an der Reihe) und "x", "o"
                val intent = intent
                val spieler1 = intent.getStringExtra("Spieler 1")
                val spieler2 = intent.getStringExtra("Spieler 2")

                currentplayer = if (currentplayer == "x") "o" else "x"
                actualplayer = if (actualplayer == spieler1) "$spieler2" else "$spieler1"
                Titelid.text = " $actualplayer ("+ currentplayer + ") ist an der Reihe"
            }
        }
    }

    private fun resetGame(){

        //Spiel zurücksetzen

        currentplayer = "x"
        Titelid.text = actualplayer +" ist an der Reihe"
        gamestate = "playing"
        for (field in allFields){
            field.text = ""

        }

    }
        //Überrüfung ob ein Spieler gewonnen hat
       private fun checkwin(): Boolean{
                //horizontale überprüfung
        return  (f11.text == f2.text && f2.text == f3.text && f11.text != "") ||
                (f4.text == f5.text && f5.text == f6.text && f4.text != "") ||
                (f7.text == f8.text && f8.text == f9.text && f7.text != "") ||
                //vertikale üperfüfung
                (f11.text == f4.text && f4.text == f7.text && f11.text != "") ||
                (f2.text == f5.text && f5.text == f8.text && f2.text != "") ||
                (f3.text == f6.text && f6.text == f9.text && f3.text != "") ||
                //diagonale Überprüfung
                (f11.text == f5.text && f5.text == f9.text && f11.text != "") ||
                (f3.text == f5.text && f5.text == f7.text && f3.text != "")

    }

}