package kitefoundation.tech.lesson1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kitefoundation.tech.lesson1.databinding.FragmentHomeBinding
import kitefoundation.tech.lesson1.databinding.FragmentSearchBinding
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment(){

    private lateinit var binding: FragmentSearchBinding
    private lateinit var bundle: Bundle

    @Inject
    lateinit var repo: SearchRepository

    private val factory: SearchViewModelFactory = SearchViewModelFactory(repo)
    private val viewModel: SearchViewModel =
        ViewModelProvider(this, factory)
            .get(SearchViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(
            inflater,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back.setOnClickListener {
            findNavController().popBackStack()
        }

        sendBtn.setOnClickListener {
            if (searchSomething.text.isEmpty()) Toast.makeText(requireContext(), "ENTER SOMETHING", Toast.LENGTH_SHORT).show()
            else {
                viewModel.getSearchString(searchSomething.text.toString())
                searchSomething.text.clear()
            }
        }
    }
}