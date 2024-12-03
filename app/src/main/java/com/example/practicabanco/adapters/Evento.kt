package com.example.practicabanco.adapters

import com.example.practicabanco.pojos.Cuenta

interface Evento {
fun enviarEvento(cuenta: Cuenta)
}
