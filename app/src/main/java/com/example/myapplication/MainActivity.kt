package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val imagen = findViewById<ImageView>(R.id.imageView)
        val boton = findViewById<Button>(R.id.bu1)
        val texto = findViewById<TextView>(R.id.escribir)
        val spini = findViewById<Spinner>(R.id.spin1)
        var aleatorio = 0
        var random2 = 0

        //Lista de nombres
        val nombres = listOf(
            "funny rizz", "el prota", "el weas"
        )

        //lista de descripciones
        val describir = listOf(
            "The original", "wuaton ctm", "The fake"
        )

        val imagenes = listOf(
            R.drawable.funny, R.drawable.goloza, R.drawable.ye

        )

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, nombres
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spini.adapter = adapter

        spini.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    imagen.setImageResource(imagenes[position])
                    texto.text = describir[position]
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        boton.setOnClickListener{
            aleatorio = Random.nextInt(0, 3)
            imagen.setImageResource(imagenes[aleatorio])
            texto.text = describir[aleatorio]
            spini.setSelection(aleatorio)
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tumadre)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart() llamado")
    }
    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause() llamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop() llamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume() llamado")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart() llamado")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy() llamado")
    }

}
