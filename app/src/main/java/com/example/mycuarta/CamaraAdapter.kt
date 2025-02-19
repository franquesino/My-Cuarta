package com.example.mycuarta

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CamaraAdapter(private val context: Context, private val camaras: List<Camara>) : BaseAdapter() {

    override fun getCount(): Int = camaras.size

    override fun getItem(position: Int): Any = camaras[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_camara, parent, false)

        val imgCamara = view.findViewById<ImageView>(R.id.imgCamara)
        val tvMarca = view.findViewById<TextView>(R.id.tvMarca)
        val tvModelo = view.findViewById<TextView>(R.id.tvModelo)

        val camara = camaras[position]

        imgCamara.setImageResource(camara.imagen)
        tvMarca.text = camara.marca
        tvModelo.text = camara.modelo

        // Al presionar la imagen, se abrirá la nueva actividad
        imgCamara.setOnClickListener {
            val intent = android.content.Intent(context, DetalleCamaraActivity::class.java)
            intent.putExtra("camara", camara)
            context.startActivity(intent)
        }

        return view
    }
}
