package com.example.practicabanco.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicabanco.R
import com.example.practicabanco.adapters.CuentasAdapter
import com.example.practicabanco.adapters.Evento
import com.example.practicabanco.databinding.FragmentCuentasBinding
import com.example.practicabanco.pojos.Cliente
import com.example.practicabanco.pojos.Cuenta
import com.example.practicabanco.pojos.DatosClientes


class CuentasFragment : Fragment() {
    lateinit var binding: FragmentCuentasBinding
    lateinit var adapterCu: CuentasAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var dividerItemDecoration: DividerItemDecoration


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCuentasBinding.inflate(inflater, container, false)

        // Obtener el cliente de los argumentos
        val cliente = arguments?.getSerializable("cliente") as? Cliente

        // Obtener la lista de cuentas usando el cliente como clave
        val lista = DatosClientes.datos.get(cliente)
        val evento = requireActivity() as? Evento

        // Verificar que la lista y el evento no son null antes de continuar
        if (lista != null && evento != null && cliente != null) {
            adapterCu = CuentasAdapter(lista, evento)
            linearLayoutManager = LinearLayoutManager(context)
            dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            binding.tvCliente.text = cliente.nombre
            binding.rvCuentas.apply {
                adapter = adapterCu
                layoutManager = linearLayoutManager
                addItemDecoration(dividerItemDecoration)
            }
        } else {
            Toast.makeText(context, "No se pudo cargar la información.", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance(c: Cliente): CuentasFragment {
            val fragment = CuentasFragment()
            val bundle = Bundle()
            bundle.putSerializable("cliente", c)
            fragment.arguments = bundle
            return fragment
        }
    }
}