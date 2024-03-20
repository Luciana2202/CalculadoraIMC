package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Recuperando os componente do XML
        val edtPeso = findViewById<TextInputEditText>(R.id.edit_text_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edit_text_altura)
        val botao = findViewById<Button>(R.id.button_calcular)


        botao.setOnClickListener {
            //Convertendo os tipos dos componetes recuperados do XML
            val pesoStr = edtPeso.text.toString()
            val alturaStr = edtAltura.text.toString()

            if( pesoStr == "" || alturaStr == ""){

                Snackbar
                    .make(
                        edtPeso,
                        "Preencha todos os campos.",
                        Snackbar.LENGTH_LONG
                    ).show()

            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()
                val resultado: Float = peso / (altura * altura)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("KEY_RESULT_IMC", resultado)
                startActivity(intent)

                println("IMC = " + resultado)
            }



        }
    }
}