package com.example.practicabanco.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicabanco.R
import com.example.practicabanco.databinding.ItemCuentasBinding
import com.example.practicabanco.pojos.Cuenta

class CuentasAdapter(val lista:List<Cuenta>, val evento:Evento ):RecyclerView.Adapter<CuentasAdapter.ViewHolder>(){
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val binding=ItemCuentasBinding.bind(view)

        fun render(cuenta: Cuenta) {
            binding.tvCuenta.text=cuenta.nombre
            binding.tvTipo.text=cuenta.tipo.toString()
            binding.tvSaldo.text=cuenta.saldo.toString()
            setEVento(cuenta)
        }

        private fun setEVento(cuenta: Cuenta) {
                evento.enviarEvento(cuenta)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cuentas,parent,false))
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.render(lista[position])
    }
}