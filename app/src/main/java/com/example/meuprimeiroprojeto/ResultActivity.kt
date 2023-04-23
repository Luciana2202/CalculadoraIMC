package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /* TABELA IMC
           MENOR QUE 18,5    ABAIXO DO PESO 0
           ENTRE 18,5 E 24,9 NORMAL         0
           ENTRE 25,0 E 29,9 SOBREPESO      I
           ENTRE 30,0 E 39,9 SOBREPESO      II
           MAIOR QUE 40,0    SOBREPESO      III
         */

        var classificacao = ""

        if(result < 18.5f){
            classificacao = "ABAIXO DO PESO"
        }else if(result in 18.5f..24.9f){
            classificacao = "NORMAL"
        }else if(result in 25f..29.9f){
            classificacao = "SOBREPESO"
        }else if(result >= 30f && result <= 39.9f){
            classificacao = "OBESIDADE"
        }else if(result >= 40.0f){
            classificacao = "OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}