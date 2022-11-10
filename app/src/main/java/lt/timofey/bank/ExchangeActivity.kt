package lt.timofey.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ExchangeActivity : AppCompatActivity() {
    val REQUEST_CODE = 10
    var currentExchange = Exchange("","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_exchange)
        val filialID = findViewById<TextView>(R.id.filialId)
        val filialText = findViewById<TextView>(R.id.filialText)
        val city = findViewById<TextView>(R.id.city)
        val workTime = findViewById<TextView>(R.id.workTime)
        var street = findViewById<TextView>(R.id.street)
        val usdIn = findViewById<TextView>(R.id.usdIn)
        val usdOut = findViewById<TextView>(R.id.usdOut)
        var eurIn = findViewById<TextView>(R.id.euroIn)
        var eurOut = findViewById<TextView>(R.id.euroOut)
        var rubIn = findViewById<TextView>(R.id.rubIn)
        var rubOut = findViewById<TextView>(R.id.rubOut)

        var usdEurIn = findViewById<TextView>(R.id.usdEurIn)
        var usdEurOut = findViewById<TextView>(R.id.usdEurOut)
        var usdRubIn = findViewById<TextView>(R.id.usdRubIn)
        var usdRubOut = findViewById<TextView>(R.id.usdRubOut)
        var rubEurIn = findViewById<TextView>(R.id.rubEurIn)
        var rubEurOut = findViewById<TextView>(R.id.rubEurOut)


        currentExchange = intent.getParcelableExtra<Exchange>("product")!!
        filialID.text = currentExchange.filial_id
        filialText.text = currentExchange.filials_text
        city.text = currentExchange.name
        workTime.text = ""
        for(char in currentExchange.info_worktime){
            if (!char.equals('|')){
                workTime.text = workTime.text.toString() + char.toString()
            }else{
                workTime.text = workTime.text.toString() + "\n"
            }
        }
        street.text = currentExchange.street_type + currentExchange.street + " " + currentExchange.home_number
        usdIn.text = currentExchange.USD_in
        usdOut.text = currentExchange.USD_out
        eurIn.text = currentExchange.EUR_in
        eurOut.text = currentExchange.EUR_out
        rubIn.text = currentExchange.RUB_in
        rubOut.text = currentExchange.RUB_out
        usdEurIn.text = currentExchange.USD_EUR_in
        usdEurOut.text = currentExchange.USD_EUR_out
        usdRubIn.text = currentExchange.USD_RUB_in
        usdRubOut.text = currentExchange.USD_RUB_out
        rubEurIn.text = currentExchange.RUB_EUR_in
        rubEurOut.text = currentExchange.RUB_EUR_out
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == AppCompatActivity.RESULT_OK) {
            currentExchange = data!!.getParcelableExtra<Exchange>("product")!!
        }
    }
}