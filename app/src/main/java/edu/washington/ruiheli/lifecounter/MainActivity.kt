package edu.washington.ruiheli.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var arrPlayerLife = arrayOf<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtPlayer1Life = findViewById<TextView>(R.id.txtPlayer1Life)
        val txtPlayer2Life = findViewById<TextView>(R.id.txtPlayer2Life)
        val txtPlayer3Life = findViewById<TextView>(R.id.txtPlayer3Life)
        val txtPlayer4Life = findViewById<TextView>(R.id.txtPlayer4Life)


        arrPlayerLife = arrayOf(
                txtPlayer1Life,
                txtPlayer2Life,
                txtPlayer3Life,
                txtPlayer4Life
        )

        val playerRadioButtonGroup = findViewById<RadioGroup>(R.id.rbgPlayers)
        val btnSubOne = findViewById<Button>(R.id.btnSub)
        val btnSubFive = findViewById<Button>(R.id.btnSub5)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnPlusFive = findViewById<Button>(R.id.btnPlus5)


        btnSubOne.setOnClickListener({
            handleClick(
                    it,
                    this.arrPlayerLife,
                    playerRadioButtonGroup
            )
        })

        btnSubFive.setOnClickListener({
            handleClick(
                    it,
                    this.arrPlayerLife,
                    playerRadioButtonGroup
            )
        })

        btnPlus.setOnClickListener({
            handleClick(
                    it,
                    this.arrPlayerLife,
                    playerRadioButtonGroup
            )
        })

        btnPlusFive.setOnClickListener({
            handleClick(
                    it,
                    this.arrPlayerLife,
                    playerRadioButtonGroup
            )
        })
    }


    private fun lifeUpdate(arrTextView: Array<TextView>, player: Int, num: Int){
        val life = arrTextView.get(player).text.toString().toInt()
        val newCount = life+num
        if (newCount <= 0) {
            val toast = Toast.makeText(applicationContext, "Player ${(player+1)} is dead", Toast.LENGTH_SHORT)
            toast.show()
        }
        arrTextView.get(player).text = (newCount).toString()
    }

    private fun playerNumberSelected(rbg: RadioGroup): Int {
        when(rbg.checkedRadioButtonId){
            R.id.rbPlayer1 -> return 0
            R.id.rnPlayer2 -> return 1
            R.id.rnPlayer3 -> return 2
            R.id.rnPlayer4 -> return 3
        }

        return -1
    }

    private fun handleClick(v: View, arrTextView: Array<TextView>, rbg: RadioGroup){
        when (v.id){
            R.id.btnPlus -> lifeUpdate(arrTextView, playerNumberSelected(rbg), 1)
            R.id.btnPlus5 -> lifeUpdate(arrTextView, playerNumberSelected(rbg), 5)
            R.id.btnSub -> lifeUpdate(arrTextView, playerNumberSelected(rbg), -1)
            R.id.btnSub5 -> lifeUpdate(arrTextView, playerNumberSelected(rbg), -5)
        }
    }
}
