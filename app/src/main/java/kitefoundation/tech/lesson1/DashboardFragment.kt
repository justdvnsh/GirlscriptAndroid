package kitefoundation.tech.lesson1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kitefoundation.tech.lesson1.databinding.FragmentDashboardBinding
import kitefoundation.tech.lesson1.databinding.FragmentHomeBinding
import kitefoundation.tech.lesson1.databinding.FragmentSearchBinding

class DashboardFragment : Fragment(){

    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }
}