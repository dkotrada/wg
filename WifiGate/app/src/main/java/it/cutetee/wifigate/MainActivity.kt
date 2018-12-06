package it.cutetee.wifigate

import android.content.Context
import android.net.wifi.WifiManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wifio: WifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        if (wifio.isWifiEnabled){
            Log.d("WIFIGATE: ", "WLAN ist AKTIVIERT")
        } else {
            Log.d("WIFIGATE: ", "WLAN ist AUSGESCHALTET")
        }
    }
}
