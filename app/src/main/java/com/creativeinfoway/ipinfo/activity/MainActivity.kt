package com.creativeinfoway.ipinfo.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.creativeinfoway.ipinfo.R
import com.creativeinfoway.ipinfo.databinding.ActivityMainBinding
import com.creativeinfoway.ipinfo.model.GeoService

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()

    }

    private fun setListener() {
        binding.btnIpapi.setOnClickListener(this)
        binding.btnIpinfo.setOnClickListener(this)
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
                    if (error != null) { showToast(error) }
                }
            }
            R.id.btn_ipinfo -> {
                GeoService.instance.getGeoDetails { details, error ->
                    if (details != null) {
                        val intent = Intent(applicationContext, IpInfoActivity::class.java)
                        intent.putExtra("geoDetails",details)
                        startActivity(intent)
                    }
                    if (error != null) { showToast(error) }
                }
            }
        }
    }
}


fun Context.showToast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}