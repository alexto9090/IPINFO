package com.creativeinfoway.ipinfo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.creativeinfoway.ipinfo.R
import com.creativeinfoway.ipinfo.model.GeoInfo
import org.json.JSONObject

class IpApiActivity : AppCompatActivity() {

    private var tvAs: TextView? = null
    private var tvCity: TextView? = null
    private var tvCountry: TextView? = null
    private var tvCountryCode: TextView? = null
    private var tvIsp: TextView? = null
    private var tvLat: TextView? = null
    private var tvLong: TextView? = null
    private var tvOrg: TextView? = null
    private var tvQuery: TextView? = null
    private var tvRegion: TextView? = null
    private var tvRegionName: TextView? = null
    private var tvStatus: TextView? = null
    private var tvTimezone: TextView? = null
    private var tvZip: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ip_api)



        initIDs()

        parseIpApiData()

    }

    private fun initIDs() {
        tvAs = findViewById(R.id.tv_as)
        tvCity = findViewById(R.id.tv_city)
        tvCountry = findViewById(R.id.tv_country)
        tvCountryCode = findViewById(R.id.tv_country_code)
        tvIsp = findViewById(R.id.tv_isp)
        tvLat = findViewById(R.id.tv_lat)
        tvLong = findViewById(R.id.tv_longti)
        tvOrg = findViewById(R.id.tv_org)
        tvQuery = findViewById(R.id.tv_query)
        tvRegion = findViewById(R.id.tv_region)
        tvRegionName = findViewById(R.id.tv_region_name)
        tvStatus = findViewById(R.id.tv_status)
        tvTimezone = findViewById(R.id.tv_timezone)
        tvZip = findViewById(R.id.tv_zip)

    }


    fun parseIpApiData() {
        val info = intent.getSerializableExtra("geoInfo") as GeoInfo

        tvAs!!.setText(info.asType)
        tvCity!!.setText(info.city)
        tvCountry!!.setText(info.country)
        tvCountryCode!!.setText(info.countryCode)
        tvIsp!!.setText(info.isp)
        tvLat!!.setText(info.lat.toString())
        tvLong!!.setText(info.lon.toString())
        tvOrg!!.setText(info.org)
        tvQuery!!.setText(info.query)
        tvRegion!!.setText(info.region)
        tvRegionName!!.setText(info.regionName)
        tvStatus!!.setText(info.status)
        tvTimezone!!.setText(info.timezone)
        tvZip!!.setText(info.zip)
    }
}

