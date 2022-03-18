package br.com.fiap.checkpoint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoContaTelefonica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_conta_telefonica)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        txtResultado.text = intent.getStringExtra("total")
    }
}