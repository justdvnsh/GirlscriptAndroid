package kitefoundation.tech.lesson1

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kitefoundation.tech.lesson1.databinding.FragmentDashboardBinding
import kitefoundation.tech.lesson1.databinding.FragmentHomeBinding
import kitefoundation.tech.lesson1.databinding.FragmentSearchBinding
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(){

    private lateinit var binding: FragmentDashboardBinding

    val recv = AirplaneReceiver()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            requireActivity().registerReceiver(recv, it)
        }
        binding.startService.setOnClickListener {
            Intent(requireContext(), MyService::class.java).also {
                it.putExtra("EXTRA_DATA", "SERVICE IS RUNNING")
                requireActivity().startService(it)
                dashboardText.text = "SERVICE HAS STARTED"
            }
        }
        binding.stopService.setOnClickListener {
            Intent(requireContext(), MyService::class.java).also {
                requireActivity().stopService(it)
                dashboardText.text = "SERVICE HAS STOPPED"
            }
        }

        binding.raiseNotifications.setOnClickListener {
            NotifMan.raiseNotification(requireContext())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().unregisterReceiver(recv)
    }
}