package com.example.notas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AgregarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agregar_nota)

        val editNota = findViewById<EditText>(R.id.editTextNota)
        val btnGuardar = findViewById<Button>(R.id.Guardar)
        val btnVolver = findViewById<Button>(R.id.VolverAgregar)

        btnGuardar.setOnClickListener {
            val textoNota = editNota.text.toString()
            if (textoNota.isNotBlank()) {
                val nuevNota = Nota(textoNota)
                PrincipalActivity.listaNotas.add(nuevNota)
                Toast.makeText(this, "Nota agregada", Toast.LENGTH_SHORT).show()
                editNota.text.clear()
            } else {
                Toast.makeText(this, "Ingrese una nota", Toast.LENGTH_SHORT).show()
            }
        }
        btnVolver.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}