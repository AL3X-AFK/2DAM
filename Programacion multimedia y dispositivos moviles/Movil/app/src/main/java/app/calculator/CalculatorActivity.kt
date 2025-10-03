package app.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test.R

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Botones de numeros
        var btnNum1 = findViewById<Button>(R.id.btnNum1)
        var btnNum2 = findViewById<Button>(R.id.btnNum2)
        var btnNum3 = findViewById<Button>(R.id.btnNum3)
        var btnNum4 = findViewById<Button>(R.id.btnNum4)
        var btnNum5 = findViewById<Button>(R.id.btnNum5)
        var btnNum6 = findViewById<Button>(R.id.btnNum6)
        var btnNum7 = findViewById<Button>(R.id.btnNum7)
        var btnNum8 = findViewById<Button>(R.id.btnNum8)
        var btnNum9 = findViewById<Button>(R.id.btnNum9)
        var btnNum0 = findViewById<Button>(R.id.btnNum0)

        //Botones de operadores
        var btnPlus = findViewById<Button>(R.id.btnPlus)
        var btnRest = findViewById<Button>(R.id.btnRest)
        var btnResult = findViewById<Button>(R.id.btnResult)

        //Espacios de texto
        var txtInput = findViewById<TextView>(R.id.txtInput)
        var txtResult = findViewById<TextView>(R.id.txtResult)

        //Numeros
        var num1 = ""
        var num2 = ""

        var operadorSeleccionado : String? = null

        val botonesNumeros = listOf(btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9)

        botonesNumeros.forEach { boton->
            boton.setOnClickListener {
                val numero = boton.text.toString()
                agregarNumero(numero)
            }
        }

        fun agregarNumero(num: String){

        }
*/
    }
}