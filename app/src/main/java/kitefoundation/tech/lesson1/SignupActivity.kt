package kitefoundation.tech.lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        takeToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        signupBtn.setOnClickListener {
            val email = emailEdit.text.toString()
            val password = passwordEdit.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        val user = hashMapOf(
                            "email" to email,
                            "name" to nameEdit.text.toString(),
                            "dob" to dobEdit.text.toString(),
                            "id" to auth.currentUser?.uid
                        )


                        db.collection("users").document(email)
                            .set(user)
                            .addOnSuccessListener {
                                startActivity(Intent(this, MainActivity::class.java))
                            }
                            .addOnFailureListener {
                                Toast.makeText(this, "SAVIGN IN THE DB FAILED", Toast.LENGTH_SHORT).show()
                            }
                    } else {
                        Toast.makeText(this, "The task of signing up was failed", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}