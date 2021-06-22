package kitefoundation.tech.lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val currentUser = auth.currentUser
        if (currentUser != null) {
            db.collection("users").document(currentUser.email!!)
                .get()
                .addOnSuccessListener {
                    Log.i("FROM THE DB", it.toString())
                }
                .addOnFailureListener {
                    Toast.makeText(this, "SAVIGN IN THE DB FAILED", Toast.LENGTH_SHORT).show()
                }
            startActivity(Intent(this, MainActivity::class.java))
        } else startActivity(Intent(this, LoginActivity::class.java))
    }
}