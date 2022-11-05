package lt.timofey.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//https://belarusbank.by/api/kursExchange
class MainActivity : AppCompatActivity() {

    val apiService = ApiService.create()
    lateinit var tv: TextView
    lateinit var exchangesList: RecyclerView
    var exchanges = listOf<Exchange>()
    val REQUEST_CODE = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById<TextView>(R.id.tw1)
        getExchange()
        val spinner = findViewById<Spinner>(R.id.citySpinner)
        spinner.onItemSelectedListener(){

        }
    }
    fun getExchange(){
        val call = apiService.getExchange()

        call.enqueue(object: Callback<List<Exchange>> {

            override fun onFailure(call: Call<List<Exchange>>, t: Throwable) {
                Log.d("!!!", t.toString())
            }

            override fun onResponse(
                call: Call<List<Exchange>>,
                response: Response<List<Exchange>>
            ) {
                exchanges = response.body()!!
                tv.text = exchanges.toString()
            }
        })}
}