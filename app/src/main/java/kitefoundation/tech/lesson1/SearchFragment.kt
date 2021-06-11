package kitefoundation.tech.lesson1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kitefoundation.tech.lesson1.databinding.FragmentHomeBinding
import kitefoundation.tech.lesson1.databinding.FragmentSearchBinding
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(){

    private lateinit var binding: FragmentSearchBinding
    private lateinit var bundle: Bundle

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            val bundle = savedInstanceState.getBundle("SEARCH_BUNDLE")
            enteredText.text = bundle?.getString("editTextValue")
        }

        back.setOnClickListener {
            findNavController().popBackStack()
        }

        sendBtn.setOnClickListener {
            if (searchSomething.text.isEmpty()) Toast.makeText(requireContext(), "ENTER SOMETHING", Toast.LENGTH_SHORT).show()
            else {
                enteredText.text = searchSomething.text.toString()
                bundle = Bundle().apply {
                    putString("editTextValue", searchSomething.text.toString())
                }
                searchSomething.text.clear()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBundle("SEARCH_BUNDLE", bundle)
    }
}