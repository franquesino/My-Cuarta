package com.example.mycuarta

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var camaras: MutableList<Camara>
    private lateinit var adapter: CamaraAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Lista de cámaras con imágenes
        camaras = mutableListOf(
            Camara(R.drawable.logitech_c920, "Logitech", "C920 HD Pro", "$80"),
            Camara(R.drawable.razer_kiyo, "Razer", "Kiyo Streaming", "$100"),
            Camara(R.drawable.microsoft_hd3000, "Microsoft", "LifeCam HD-3000", "$40"),
            Camara(R.drawable.elgato_facecam, "Elgato", "Facecam Premium", "$150"),
            Camara(R.drawable.logitech_brio, "Logitech", "Brio Ultra HD 4K", "$200")
        )

        listView = findViewById(R.id.listViewCamaras)
        adapter = CamaraAdapter(this, camaras)
        listView.adapter = adapter

        // Registrar el ListView para el menú contextual
        registerForContextMenu(listView)
    }

    // Inflar el menú contextual
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_contextual, menu)
    }

    // Manejar las opciones del menú contextual
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        when (item.itemId) {
            R.id.eliminar -> {
                camaras.removeAt(info.position) // Eliminar la cámara de la lista
                adapter.notifyDataSetChanged()  // Actualizar la lista
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}
