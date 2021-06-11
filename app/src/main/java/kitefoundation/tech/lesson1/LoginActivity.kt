package kitefoundation.tech.lesson1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        rateUsBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://google.com"))
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            // INTENTS
            // EXPLICIT -> When we want to open up an our own activity
            // IMPLICIT -> when we want to open up an activity which is not one of our own , we use implicit intents
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("STRING1", "THIS IS STRING1")
            intent.putExtra("STRING2", "THIS IS STRING2")
            startActivity(intent)
        }


        fileChooser.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, 101)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                val imageFile = intent?.data
                Log.i("IMAGE", imageFile.toString())
                iv.setImageURI(imageFile)
            }
        }
    }

}