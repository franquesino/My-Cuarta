package com.example.mycuarta

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Lista de cámaras web disponibles
        val camaras = listOf(
            "Logitech C920 - HD Pro Webcam",
            "Razer Kiyo - Streaming Webcam",
            "Microsoft LifeCam HD-3000",
            "Elgato Facecam - Premium Webcam",
            "Logitech Brio - Ultra HD 4K Webcam"
        )

        // Referencia al ListView desde el layout
        val listView: ListView = findViewById(R.id.listViewCamaras)

        // Adaptador para mostrar los datos en el ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, camaras)
        listView.adapter = adapter

        // Manejo de clic en un elemento del ListView
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = camaras[position]
            Toast.makeText(this, "Seleccionaste: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}
