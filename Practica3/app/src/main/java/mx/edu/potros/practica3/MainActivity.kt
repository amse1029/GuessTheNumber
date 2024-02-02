package mx.edu.potros.practica3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var minValue=0
    var maxValue=100
    var num:Int=0
    var won=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciar los elementos del Layout
        val guessing:TextView=findViewById(R.id.guessing)
        val down:Button=findViewById(R.id.btnDown)
        val up:Button=findViewById(R.id.btnUp)
        val generate:Button=findViewById(R.id.generate)
        val guessed:Button=findViewById(R.id.guessed)

        fun resetValues(){
            minValue=0
            maxValue=100
            num=0
            won=false
        }

        fun checkingLimits(): Boolean{
            return minValue!=maxValue
        }

        generate.setOnClickListener {
            num = Random.nextInt(minValue,maxValue)
            guessing.setText(num.toString())
            generate.visibility= View.INVISIBLE
            guessed.visibility= View.VISIBLE
        }

        up.setOnClickListener {
            minValue=num
            if(checkingLimits()) {
                num=Random.nextInt(minValue, maxValue)
                guessing.setText(num.toString())
            } else {
                guessing.setText("No puede ser ;( me ganaste")
            }
        }
        //Para instanciar el evento click es el de llaves
        down.setOnClickListener {
            maxValue=num
            if(checkingLimits()){
                num= Random.nextInt(minValue, maxValue)

                guessing.setText(num.toString())
            } else {
                guessing.setText(num.toString())
            }
        }

        guessed.setOnClickListener {
            if(!won){
                guessing.setText("Adivine, tu número es el "+num)
                guessed.setText("Volver a ")
                won=true
            } else {
                generate.visibility=View.VISIBLE
                generate.setText("Tap on generate to start")
                guessed.visibility=View.GONE
                resetValues()
            }
        }


    }
}