package com.nitesh.ipinfo.lib

import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.Serializable
import java.util.concurrent.TimeUnit


public class GeoServices {

    //Singleton Object
    companion object {
        val instance = GeoServices()
    }

    //Lazy Variables
    private val httpClient: OkHttpClient by lazy {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(3, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES).build()
    }

    private val geoInfoBuilder: Call<GeoInfo> by lazy {
        val retrofit = Retrofit.Builder().baseUrl("http://www.ip-api.com/json/")
            .addConverterFactory(GsonConverterFactory.create()).client(httpClient).build()
        val retrofitApiInterface = retrofit.create(GeoInterface::class.java)
        retrofitApiInterface.geoInfo()
    }


    private val geoDetailsBuilder: Call<ResponseBody> by lazy {
        val retrofit = Retrofit.Builder().baseUrl("https://ipinfo.io/org/")
            .addConverterFactory(GsonConverterFactory.create()).client(httpClient).build()
        val retrofitApiInterface = retrofit.create(GeoInterface::class.java)
        retrofitApiInterface.geoDetails()
    }


    //Public Function
    fun getGeoIp(handler: (result: GeoInfo?, String?) -> Unit) {
        geoInfoBuilder.enqueue(object : Callback<GeoInfo> {

            override fun onResponse(call: Call<GeoInfo>, response: Response<GeoInfo>) {
                handler.invoke(response.body(), null)
            }

            override fun onFailure(call: Call<GeoInfo>, t: Throwable) {
                handler.invoke(null, t.localizedMessage)
            }
        })
    }


    fun getGeoDetails(handler: (result: String?, String?) -> Unit) {
        geoDetailsBuilder.enqueue(object : Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                handler.invoke(response.body()!!.string(), null)
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                handler.invoke(null, t.localizedMessage)
            }
        })
    }

}


interface GeoInterface {

    @GET("http://www.ip-api.com/json")
    fun geoInfo(): Call<GeoInfo>

    @GET("https://ipinfo.io/org/")
    fun geoDetails(): Call<ResponseBody>
}


class GeoInfo : Serializable {

    @SerializedName("as")
    public var asType: String? = null
    @SerializedName("city")
    public var city: String? = null
    @SerializedName("country")
    public var country: String? = null
    @SerializedName("countryCode")
    public var countryCode: String? = null
    @SerializedName("isp")
    public var isp: String? = null
    @SerializedName("lat")
    public var lat: Double? = null
    @SerializedName("lon")
    public var lon: Double? = null
    @SerializedName("org")
    public var org: String? = null
    @SerializedName("query")
    public var query: String? = null
    @SerializedName("region")
    public var region: String? = null
    @SerializedName("regionName")
    public var regionName: String? = null
    @SerializedName("status")
    public var status: String? = null
    @SerializedName("timezone")
    public var timezone: String? = null
    @SerializedName("zip")
    public var zip: String? = null
}