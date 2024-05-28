package com.bangkit.eyetify

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.bangkit.eyetify.databinding.ActivityMainBinding
import com.bangkit.eyetify.ui.fragment.ArticleFragment
import com.bangkit.eyetify.ui.fragment.HistoryFragment
import com.bangkit.eyetify.ui.fragment.HomeFragment
import com.bangkit.eyetify.ui.fragment.ProfileFragment
import com.bangkit.eyetify.ui.fragment.ScanFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        switchFragment(HomeFragment())

        binding.navigateMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.action_home -> switchFragment(HomeFragment())

                R.id.action_history -> switchFragment(HistoryFragment())

                R.id.action_scan -> switchFragment(ScanFragment())

                R.id.action_article -> switchFragment(ArticleFragment())

                R.id.action_profile -> switchFragment(ProfileFragment())
            }
            true
        }

    }

    private fun switchFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container_fragment, fragment)
        fragmentTransaction.commit()
    }
}