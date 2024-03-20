package com.example.meuprimeiroprojeto


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra("KEY_RESULT_IMC", 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificação)

        tvResult.text = result.toString()


        val classificacao = if(result <= 18.5f){
            "MAGREZA"
        } else if(result > 18.5f && result <= 24.9f){
            "NORMAL"
        } else if (result > 25f && result <= 29.9f){
            "SOBREPESO"
        } else if(result > 30f && result <= 39.9f){
            "OBESIDADE"
        } else{
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = classificacao

        if (classificacao == "MAGREZA"){
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.yellow))
        } else if (classificacao == "NORMAL"){
            tvClassificacao.setTextColor(ContextCompat.getColor(this,R.color.green))
        } else if (classificacao == "SOBREPESO"){
            tvClassificacao.setTextColor(ContextCompat.getColor(this,R.color.yellow))
        } else if (classificacao == "OBESIDADE"){
            tvClassificacao.setTextColor(ContextCompat.getColor(this,R.color.red))
        } else {
            tvClassificacao.setTextColor(ContextCompat.getColor(this,R.color.red))
        }

    }
}

