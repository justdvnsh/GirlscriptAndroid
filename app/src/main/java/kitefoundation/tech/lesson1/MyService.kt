package kitefoundation.tech.lesson1

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val data = intent?.extras?.getString("EXTRA_DATA")
        data?.let {
            Log.d("SERVICE", it)
        }
        return START_STICKY
    }
}