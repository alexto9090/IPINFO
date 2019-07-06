package com.creativeinfoway.ipinfo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.creativeinfoway.ipinfo.R

class IpInfoActivity : AppCompatActivity() {
    private var tvInfo: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ip_info)

        initIDs()

        parseIpinfo()

    }

    private fun initIDs() {
        tvInfo = findViewById(R.id.tv_ipinfo)
    }

    fun parseIpinfo() {
        val apidata = intent.getStringExtra("geoDetails")
        tvInfo!!.setText(apidata)
    }
}
