package com.example.mycuarta

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleCamaraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_camara)

        val camara = intent.getSerializableExtra("camara") as Camara

        val imgCamara = findViewById<ImageView>(R.id.imgCamaraDetalle)
        val tvMarca = findViewById<TextView>(R.id.tvMarcaDetalle)
        val tvModelo = findViewById<TextView>(R.id.tvModeloDetalle)
        val tvPrecio = findViewById<TextView>(R.id.tvPrecioDetalle)

        imgCamara.setImageResource(camara.imagen)
        tvMarca.text = "Marca: ${camara.marca}"
        tvModelo.text = "Modelo: ${camara.modelo}"
        tvPrecio.text = "Precio: ${camara.precio}"
    }
}
