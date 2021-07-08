package com.creativeinfoway.ipinfo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.creativeinfoway.ipinfo.databinding.ActivityIpInfoBinding

class IpInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIpInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIpInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parseIpInfo()
    }

    private fun parseIpInfo() {
        with(binding) {
            val apiData = intent.getStringExtra("geoDetails")
            tvIpinfo.text = apiData
        }
    }
}
