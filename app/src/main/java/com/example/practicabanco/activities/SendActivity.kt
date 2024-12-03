package com.example.practicabanco.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicabanco.R
import com.example.practicabanco.adapters.Evento
import com.example.practicabanco.databinding.ActivitySendBinding
import com.example.practicabanco.fragments.CuentasFragment
import com.example.practicabanco.pojos.Cliente
import com.example.practicabanco.pojos.Cuenta

class SendActivity : AppCompatActivity(),Evento {
    lateinit var binding: ActivitySendBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recibimos de un fragment a una actividad
        val cliente=intent.getSerializableExtra("cliente") as Cliente
        Toast.makeText(this,"Valor ${cliente.nombre}",Toast.LENGTH_LONG).show()

        // envamos de un actividad a un fragment
        val fragment= CuentasFragment.newInstance(cliente)
        val envio=supportFragmentManager.beginTransaction()
        envio.replace(R.id.fragmentContainerCuentas,fragment)
        envio.commit()

    }

    override fun enviarEvento(cuenta: Cuenta) {
       Toast.makeText(this,"Evento desde SendActivity",Toast.LENGTH_LONG).show()
    }
}