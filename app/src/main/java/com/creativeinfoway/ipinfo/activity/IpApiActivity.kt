package com.creativeinfoway.ipinfo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.creativeinfoway.ipinfo.databinding.ActivityIpApiBinding
import com.creativeinfoway.ipinfo.model.GeoInfo

class IpApiActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIpApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIpApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parseIpApiData()
    }

    private fun parseIpApiData() {
        with(binding) {
            val info = intent.getSerializableExtra("geoInfo") as GeoInfo
            tvAs.text = info.asType
            tvCity.text = info.city
            tvCountry.text = info.country
            tvCountryCode.text = info.countryCode
            tvIsp.text = info.isp
            tvLat.text = info.lat.toString()
            tvLongti.text = info.lon.toString()
            tvOrg.text = info.org
            tvQuery.text = info.query
            tvRegion.text = info.region
            tvRegionName.text = info.regionName
            tvStatus.text = info.status
            tvTimezone.text = info.timezone
            tvZip.text = info.zip
        }
    }
}

