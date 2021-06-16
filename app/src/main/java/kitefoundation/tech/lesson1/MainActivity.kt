package kitefoundation.tech.lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import kitefoundation.tech.lesson1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainNavhost) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNavigation, navHostFragment.findNavController())
        navHostFragment.findNavController().addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.homeFragment2 -> bottomNavigation.visibility = View.VISIBLE
                R.id.dashboardFragment2 -> bottomNavigation.visibility = View.VISIBLE
                R.id.settingsFragment2 -> bottomNavigation.visibility = View.VISIBLE
                else -> bottomNavigation.visibility = View.GONE
            }
        }
    }
}