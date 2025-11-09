package com.example.notas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class InicioActivity: AppCompatActivity() {
    override fun onCreate(savesinstanceState: Bundle?) {
        super.onCreate(savesinstanceState)
        setContentView(R.layout.activity_inicio)

        val btnEntrar = findViewById<Button>(R.id.Entrar)

        btnEntrar.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }
    }
}