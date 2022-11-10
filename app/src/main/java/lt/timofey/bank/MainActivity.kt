package lt.timofey.bank

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
    var exchangesFilteredByCity = listOf<Exchange>()
    val REQUEST_CODE = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //tv = findViewById<TextView>(R.id.tw1)
        getExchange()
        val spinner = findViewById<Spinner>(R.id.citySpinner)
        val itemSelectedListener: AdapterView.OnItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val item = parent.getItemAtPosition(position) as String
                    Toast.makeText(this@MainActivity, item,Toast.LENGTH_LONG).show()
                    exchangesFilteredByCity = exchanges.filter{it.name.equals(item)}
                    //tv.text = exchangesFilteredByCity.toString()
                    exchangesList = findViewById(R.id.recyclerView)
                    exchangesList.layoutManager = LinearLayoutManager(this@MainActivity)
                    exchangesList.adapter = ExchangeAdapter(exchangesFilteredByCity,this@MainActivity)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        spinner.onItemSelectedListener = itemSelectedListener
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
                //tv.text = exchanges.toString()
                exchangesFilteredByCity = exchanges.filter{it.name.equals("Минск")}
                //tv.text = exchangesFilteredByCity.toString()
                exchangesList = findViewById(R.id.recyclerView)
                exchangesList.layoutManager = LinearLayoutManager(this@MainActivity)
                exchangesList.adapter = ExchangeAdapter(exchangesFilteredByCity,this@MainActivity)
            }
        })}
}