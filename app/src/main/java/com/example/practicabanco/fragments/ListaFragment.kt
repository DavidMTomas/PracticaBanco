package com.example.practicabanco.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.practicabanco.activities.SendActivity
import com.example.practicabanco.databinding.FragmentListaBinding
import com.example.practicabanco.pojos.DatosClientes


class ListaFragment : Fragment() {
lateinit var binding:FragmentListaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentListaBinding.inflate(inflater,container,false)

        val lista=DatosClientes.datos.map { it.key.nombre}
        val adapter=ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item,lista)


       var spinner= binding.spClientes
        spinner.adapter=adapter

        var eleccion:String=""
        spinner.onItemSelectedListener=object :OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               eleccion=lista.get(position)
                Toast.makeText(context, "$eleccion", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.cuentaPropia.setOnCheckedChangeListener { buttonView, isChecked ->
           if(isChecked)
            modificar(true)
        }
        binding.cbCuentaAjena.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
            modificar(false)
        }



        binding.btnEnviar.setOnClickListener {
            //Enviamos a una actividad
            val intent=Intent(context, SendActivity::class.java)
            val clienteSeleccionado = DatosClientes.datos.keys.find { it.nombre == eleccion }
            intent.putExtra("cliente", clienteSeleccionado)
            startActivity(intent)

        }


        return binding.root
    }

    fun modificar(i: Boolean){
        if(i){
            binding.cbCuentaAjena.isChecked=false
        }else {
            binding.cuentaPropia.isChecked=false
        }
    }
}