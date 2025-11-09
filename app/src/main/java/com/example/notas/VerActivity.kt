package com.example.notas

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class VerActivity : AppCompatActivity() {
    private lateinit var listViewNota: ListView
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.ver_notas)

        listViewNota = findViewById(R.id.listViewNotas)
        val btnEliminar = findViewById<Button>(R.id.EliminarNota)
        val btnvolver = findViewById<Button>(R.id.VolverVer)

        //Mostrar notas
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_activated_1,
            PrincipalActivity.listaNotas.map { it.contenido }
        )
        listViewNota.adapter = adapter
        listViewNota.choiceMode = ListView.CHOICE_MODE_SINGLE

        // Mantener nota seleccionada
        listViewNota.setOnItemClickListener { _, view, position, _ ->
            listViewNota.setItemChecked(position, true)
            val notaSeleccionada = PrincipalActivity.listaNotas[position]
            Toast.makeText(this, notaSeleccionada.contenido, Toast.LENGTH_LONG).show()
        }

        //Eliminar nota
        btnEliminar.setOnClickListener {
            val posicion = listViewNota.checkedItemPosition
            if(posicion != ListView.INVALID_POSITION){
                PrincipalActivity.listaNotas.removeAt(posicion)
                actualizarlista()
                Toast.makeText(this,"Nota eliminada",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Seleccione una nota",Toast.LENGTH_SHORT).show()
            }
        }
        btnvolver.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
            finish()
        }
        listViewNota.setOnItemClickListener { _, _, position, _ ->
            val notaSeleccionada = PrincipalActivity.listaNotas[position]
            Toast.makeText(this, notaSeleccionada.contenido, Toast.LENGTH_LONG).show()
        }
    }

    private fun actualizarlista(){
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_activated_1,
            PrincipalActivity.listaNotas.map { it.contenido }
        )
        listViewNota.adapter = adapter
    }
}

