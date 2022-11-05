package lt.timofey.bank


import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


val BASE_URL = "https://belarusbank.by/api/"

interface ApiService {

    @GET("kursExchange")
    fun getExchange(): Call<List<Exchange>>

    companion object Factory{
        fun create(): ApiService{
            val okHttpClient = OkHttpClient.Builder()
                .build()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

}