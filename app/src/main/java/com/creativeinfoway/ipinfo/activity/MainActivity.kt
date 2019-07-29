package com.creativeinfoway.ipinfo.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.creativeinfoway.ipinfo.R

import com.creativeinfoway.ipinfo.model.GeoService
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit





class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btnIpApi: Button? = null
    private var btnIpInfo: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initId()
    }

    private fun initId() {
        btnIpApi = findViewById(com.creativeinfoway.ipinfo.R.id.btn_ipapi)
        btnIpInfo = findViewById(com.creativeinfoway.ipinfo.R.id.btn_ipinfo)

        btnIpApi!!.setOnClickListener(this)
        btnIpInfo!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_ipapi -> {
                GeoService.instance.getGeoIp { info, error ->
                    if (info != null) {
                        val intent = Intent(applicationContext, IpApiActivity::class.java)
                        intent.putExtra("geoInfo",info)
                        startActivity(intent)
                    }
                    if (error != null) { showToast(error!!) }
                }
            }
            R.id.btn_ipinfo -> {
                GeoService.instance.getGeoDetails { details, error ->
                    if (details != null) {
                        val intent = Intent(applicationContext, IpInfoActivity::class.java)
                        intent.putExtra("geoDetails",details)
                        startActivity(intent)
                    }
                    if (error != null) { showToast(error!!) }
                }
            }
        }
    }
}


fun Context.showToast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}