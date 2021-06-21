package kitefoundation.tech.lesson1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AirplaneReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val enabled = intent?.getBooleanExtra("state", false) ?: return
        if (enabled) Log.i("AIRPLANE", "AIRPLANE MODE ON")
        else Log.i("AIRPLANE", "AIRPLANE MODE OFF")
    }
}