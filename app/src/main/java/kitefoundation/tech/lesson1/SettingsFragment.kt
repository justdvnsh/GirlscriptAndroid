package kitefoundation.tech.lesson1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kitefoundation.tech.lesson1.databinding.FragmentDashboardBinding
import kitefoundation.tech.lesson1.databinding.FragmentHomeBinding
import kitefoundation.tech.lesson1.databinding.FragmentSearchBinding
import kitefoundation.tech.lesson1.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(){

    private lateinit var binding: FragmentSettingsBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(
            inflater,
            container,
            false
        )
        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logoutBtn.setOnClickListener {
            auth.signOut()
            requireActivity().finish()
        }
    }
}