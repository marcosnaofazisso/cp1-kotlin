package br.com.fiap.checkpoint1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculadora = findViewById<Button>(R.id.btnCalculadora)
        btnCalculadora.setOnClickListener {
            val intentCalculadora = Intent(this, Calculadora::class.java)
            startActivity(intentCalculadora)
        }

        val btnContaTelefonica = findViewById<Button>(R.id.btnContaTelefonica)
        btnContaTelefonica.setOnClickListener {
            val intentContaTelefonica = Intent(this, ContaTelefonica::class.java)
            startActivity(intentContaTelefonica)
        }


        val btnIntegrantes = findViewById<Button>(R.id.btnIntegrantes)
        btnIntegrantes.setOnClickListener {
            val integrantes = """Cristine Acocella Piccolotto Vasconcellos 
                    |Jonathan Felix
                    |Marcos Vinicis Ferreira""".trimMargin("|")
            alert("Desenvolvido por", integrantes)
        }

    }

    fun alert(titulo: String, mensagem: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(titulo).setMessage(mensagem).setPositiveButton("OK", null)
        builder.create().show()
    }
}