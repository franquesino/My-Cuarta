package com.example.mycuarta

import java.io.Serializable

data class Camara(
    val imagen: Int,  // ID del recurso de imagen
    val marca: String,
    val modelo: String,
    val precio: String
) : Serializable // Para pasar datos entre actividades
