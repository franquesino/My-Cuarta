package com.example.mycuarta

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Lista de cámaras con imágenes (usa imágenes en drawable)
        val camaras = listOf(
            Camara(R.drawable.logitech_c920, "Logitech", "C920 HD Pro", "$80"),
            Camara(R.drawable.razer_kiyo, "Razer", "Kiyo Streaming", "$100"),
            Camara(R.drawable.microsoft_hd3000, "Microsoft", "LifeCam HD-3000", "$40"),
            Camara(R.drawable.elgato_facecam, "Elgato", "Facecam Premium", "$150"),
            Camara(R.drawable.logitech_brio, "Logitech", "Brio Ultra HD 4K", "$200")
        )

        val listView: ListView = findViewById(R.id.listViewCamaras)
        val adapter = CamaraAdapter(this, camaras)
        listView.adapter = adapter
    }
}
