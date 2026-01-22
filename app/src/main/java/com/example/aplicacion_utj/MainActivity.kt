package com.example.aplicacion_utj

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}