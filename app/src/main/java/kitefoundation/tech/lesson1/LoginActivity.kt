package kitefoundation.tech.lesson1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        takeToSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        loginBtn.setOnClickListener {
            val email = emailEditLogin.text.toString()
            val password = passwordEditLogin.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) startActivity(Intent(this, MainActivity::class.java))
                    else Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                }
        }
    }

}