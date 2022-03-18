package br.com.fiap.checkpoint1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val txtValor1 = findViewById<EditText>(R.id.txtValor1)
        var txtValor2 = findViewById<EditText>(R.id.txtValor2)
        var operacao = findViewById<RadioGroup>(R.id.radioGroup)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener{
            if (validacaoDeValores(txtValor1,txtValor2)) {
                val valor1 = txtValor1.text.toString().toDouble()
                val valor2 = txtValor2.text.toString().toDouble()
                val resultado : Double

                val operacao = when (operacao.checkedRadioButtonId) {
                    R.id.rdSoma -> {
                        resultado = valor1 + valor2
                        Toast.makeText(this, "Soma: ${String.format("%.2f",resultado)}", Toast.LENGTH_LONG).show();
                    }
                    R.id.rdSubtracao -> {
                        resultado = valor1 - valor2
                        Toast.makeText(this, "Subtração: ${String.format("%.2f",resultado)}",Toast.LENGTH_LONG).show();
                    }
                    R.id.rdMultiplicacao -> {
                        resultado = valor1 * valor2
                        Toast.makeText(this, "Multiplicação: ${String.format("%.2f",resultado)}",Toast.LENGTH_LONG).show();
                    }
                    R.id.rdDivisao -> {
                        val divisaoPorZero = "Jamais dividireis por zero!"
                        if (valor2 == 0.0 || valor2 * 10 <= 0) {
                        Toast.makeText(this, divisaoPorZero,Toast.LENGTH_LONG).show();
                        } else {
                            resultado = valor1 / valor2
                            Toast.makeText(this, "Divisão: ${String.format("%.2f",resultado)}",Toast.LENGTH_LONG).show();
                        }
                    }
                    else -> "Opcao invalida!"
                }

            }
        }

    }

    fun validacaoDeValores(valor1 : EditText, valor2 : EditText) : Boolean {
        if (valor1.text.trim().isEmpty() || valor2.text.trim().isEmpty()) {
            Toast.makeText(this, "Preencha todos os valores!", Toast.LENGTH_LONG).show()
            return false
        } else {
            return true
        }

    }
}