package com.wtsystems.infuel

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbarMain = findViewById<Toolbar>(R.id.toolbar)
        toolbarMain.title = "InFuel"
        toolbarMain.setTitleTextColor(Color.parseColor("#FFFFFF"))
        setSupportActionBar(findViewById(R.id.toolbar))


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.title.toString().equals("Sair")){
            finishAffinity()
        }
        return super.onOptionsItemSelected(item)

    }


    fun calcValores(view : View){
        //recuperar valores
        var precoAlcool = findViewById<TextView>(R.id.editTextAlc)
        var precoGas = findViewById<TextView>(R.id.editTextGas)
        var resposta = findViewById<TextView>(R.id.txtResp)

        val validaCampos = validarCampos(precoAlcool.text.toString(), precoGas.text.toString())
        if(validaCampos){
            calcularMelhorPreco(precoAlcool.text.toString(), precoGas.text.toString())
        }else{
            resposta.text = "Existem campos com valores inválidos!"
        }

    }

    fun validarCampos(precoAlcool : String, precoGasolina : String) : Boolean{
        var camposValidados : Boolean = true

        if(precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if(precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }

        return camposValidados
    }

    fun calcularMelhorPreco(precoAlcool : String, precoGasolina : String){
        var precoAlcoolDigitado = precoAlcool.toDouble()
        var precoGasolinaDigitado = precoGasolina.toDouble()
        var respostafinal = findViewById<TextView>(R.id.txtResp)
        var resultadoFinal = precoAlcoolDigitado/precoGasolinaDigitado

        if(resultadoFinal >= 0.7){

            respostafinal.text = "Abastecer com GASOLINA"
        }else{
            respostafinal.text = "Abastecer com ÁLCOOL"
        }

    }
}