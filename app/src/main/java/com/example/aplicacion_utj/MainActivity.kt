package com.example.aplicacion_utj

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.toString

class MainActivity : AppCompatActivity() {

    //Declaracion de instancias de clases
    private lateinit var objCliente: Cliente
    private lateinit var objProducto: Producto


    private lateinit var titulo: TextView
    private lateinit var nom: EditText
    private lateinit var correo: EditText
    private lateinit var tel: EditText
    private lateinit var con: EditText
    private lateinit var nip: EditText
    private lateinit var cp: EditText
    private lateinit var comm: EditText
    private lateinit var fecha: EditText
    private lateinit var hora: EditText
    private lateinit var codigo: EditText
    private lateinit var costo: EditText
    private lateinit var desc: AutoCompleteTextView

    private lateinit var cancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        objCliente = Cliente()
        objProducto = Producto("00-00-00", "00-00", 123, 0.10, "Nuevo producto")


        titulo = findViewById(R.id.textView)
        nom = findViewById(R.id.nombredittxt)
        correo = findViewById(R.id.editEmail)
        tel = findViewById(R.id.editPhone)
        con = findViewById(R.id.editPass)
        nip = findViewById(R.id.editNip)
        cp = findViewById(R.id.editCp)
        comm = findViewById(R.id.editComent)
        fecha = findViewById(R.id.editDate)
        hora = findViewById(R.id.editTime)
        codigo = findViewById(R.id.editCode)
        costo = findViewById(R.id.editCost)
        desc = findViewById(R.id.editDescription)
        cancel = findViewById(R.id.buttonCancel)


        val productos: Array<String> = resources.getStringArray(R.array.lista_productos)

        val adapter : ArrayAdapter<String> = ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line, productos)
        desc.setAdapter(adapter)


        titulo.apply {
            text = "FORMULARIO DE REGISTRO"
            setTextColor(Color.CYAN)
        }

        titulo.setOnClickListener {
            titulo.setTextColor(Color.BLUE)
            Toast.makeText(this, "Cambio de color", Toast.LENGTH_SHORT).show()

        }

        cancel.setOnClickListener{
                Toast.makeText(this, "Operacion cancelada", Toast.LENGTH_SHORT).show()
        }

        fun registrar(view: View?) {
            if (nom.text.isNotEmpty() && con.text.isNotEmpty() && nip.text.isNotEmpty()) {
                objCliente.nombre = nom.text.toString()
                objCliente.contrasena = con.text.toString()
                objCliente.nip = nip.text.toString().toInt()
                objCliente.correo = correo.text.toString()
                objCliente.telefono = tel.text.toString()
                objCliente.cp = cp.text.toString().toInt()
                objCliente.comentarios = comm.text.toString()

                objProducto.fecha = fecha.text.toString()
                objProducto.hora = hora.text.toString()
                objProducto.codigo = codigo.text.toString().toInt()
                objProducto.costo = costo.text.toString().toDouble()
                objProducto.description = desc.text.toString()
                Toast.makeText(
                    this, "Nombre ${objCliente.nombre} registrado\n " +
                            "Producto: ${objProducto.description} \n" +
                            "Codigo:  ${objProducto.codigo}", Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(this, "Faltan datos obligatorios", Toast.LENGTH_SHORT).show()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}