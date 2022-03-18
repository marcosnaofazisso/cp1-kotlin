package br.com.fiap.checkpoint1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ContaTelefonica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta_telefonica)


        val txtAssinatura = findViewById<EditText>(R.id.txtAssinatura)
        val txtLocal = findViewById<EditText>(R.id.txtChamadaLocal)
        val txtCelular = findViewById<EditText>(R.id.txtChamadaCelular)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularConta)

        btnCalcular.setOnClickListener {
            if (validacaoDeCampos(txtAssinatura, txtLocal, txtCelular)) {

                val valorAssinatura = txtAssinatura.text.toString().toDouble()
                val valorLocal = txtLocal.text.toString().toDouble() * 0.04
                val valorCelular = txtCelular.text.toString().toDouble() * 0.2
                val valorTotal = (valorAssinatura + valorLocal + valorCelular)

                val intentResultadoContaTelefonica = Intent(this, ResultadoContaTelefonica::class.java)

                val contaTotal =  """Assinatura:        R$ ${String.format("%.2f", valorAssinatura)}
                    |Chamada Local:         R$${String.format("%.2f", valorLocal)}
                    |Chamada Celular:         R$${String.format("%.2f", valorCelular)}
                    |Valor Total:       R$${String.format("%.2f", valorTotal)}""".trimMargin("|")

                intentResultadoContaTelefonica.putExtra("total", contaTotal)

                startActivity(intentResultadoContaTelefonica)

            }
        }


    }

    fun validacaoDeCampos(assinatura : EditText, local : EditText, celular : EditText) : Boolean {
        if (assinatura.text.trim().isEmpty() || local.text.trim().isEmpty() || celular.text.trim().isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            return false
        } else {
            return true
        }
    }

}