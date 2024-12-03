package com.example.practicabanco.pojos

class DatosClientes {
    companion object {
        // Mapa de clientes y sus respectivas listas de cuentas
        val datos: MutableMap<Cliente, List<Cuenta>> = mutableMapOf(
            Cliente("Pepe") to listOf(
                Cuenta("Cuenta Ahorros", 5000.0f, Tipo.AHORRO),
                Cuenta("Cuenta Corriente", 1500.0f, Tipo.CORRIENTE),
                Cuenta("Cuenta Inversión", 10000.0f, Tipo.INVERSION)
            ),
            Cliente("Juan") to listOf(
                Cuenta("Cuenta Nómina", 2000.0f, Tipo.NOMINA),
                Cuenta("Cuenta Ahorros", 3000.0f, Tipo.AHORRO)
            ),
            Cliente("María") to listOf(
                Cuenta("Cuenta Corriente", 1500.0f, Tipo.CORRIENTE),
                Cuenta("Cuenta Ahorros", 10000.0f, Tipo.AHORRO)
            ),
            Cliente("Carlos") to listOf(
                Cuenta("Cuenta Inversión", 7000.0f, Tipo.INVERSION),
                Cuenta("Cuenta Nómina", 5000.0f, Tipo.NOMINA),
                Cuenta("Cuenta Corriente", 2000.0f, Tipo.CORRIENTE)
            ),
            Cliente("Ana") to listOf(
                Cuenta("Cuenta Ahorros", 3000.0f, Tipo.AHORRO),
                Cuenta("Cuenta Corriente", 500.0f, Tipo.CORRIENTE)
            )
        )
    }
}