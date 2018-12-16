package it.cutetee.wifigate

import android.content.Context
import android.net.wifi.WifiManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var wifi: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wifi  = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        val net = wifi.configuredNetworks // Returns List<WifiConfiguration>
        // Ausgabe aller irgendwann mal verbundener WLANs SSID
        net.forEach {
            Log.d("SSID ", it.SSID)
        }


        // Log.d("SSID ", net[0].SSID)


        if (wifi.isWifiEnabled){
            Log.d("WIFIGATE: ", "WLAN ist AKTIVIERT")
            Toast.makeText(applicationContext, "WLAN Aktiv", Toast.LENGTH_LONG).show()

        } else {
            Log.d("WIFIGATE: ", "WLAN ist AUSGESCHALTET")
            Toast.makeText(applicationContext, "WLAN Ausgeschaltet", Toast.LENGTH_LONG).show()

        }

        val button = findViewById<Button>(R.id.buttonDisconnect)
        button?.setOnClickListener {
            Toast.makeText(applicationContext, "Hello", Toast.LENGTH_LONG).show()
        }

    }

    private fun getPin() {
        val pin = findViewById<EditText>(R.id.editTextPin)
        if (pin != null) {
            Toast.makeText(this, pin.text, Toast.LENGTH_LONG).show()
        }
    }
}
