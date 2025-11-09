package com.example.notas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.Button

class PrincipalActivity : AppCompatActivity() {
    companion object{
        val listaNotas = mutableListOf<Nota>()
    }
    override fun onCreate(savesInstanceState: Bundle?){
        super.onCreate(savesInstanceState)
        setContentView(R.layout.activity_principal)

        val btnAgregar = findViewById<Button>(R.id.AgregarNota)
        val btnVer = findViewById<Button>(R.id.VerNotas)

        btnAgregar.setOnClickListener{
            val intent = Intent(this, AgregarActivity::class.java)
            startActivity(intent)
        }
        btnVer.setOnClickListener{
            val intent = Intent(this, VerActivity::class.java)
            startActivity(intent)
        }
    }
}