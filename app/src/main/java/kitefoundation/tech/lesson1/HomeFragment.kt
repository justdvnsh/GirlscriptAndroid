package kitefoundation.tech.lesson1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kitefoundation.tech.lesson1.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment(){

    private lateinit var binding: FragmentHomeBinding

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment2_to_searchFragment2)
        }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.todoResponse.observe(
            viewLifecycleOwner,
            Observer {
                val todoAdapter = TodoAdapter(it)
                binding.responseRV.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = todoAdapter
                }
            }
        )
    }
}