package com.example.bottomnavview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.bottomnavview.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replacewithfrag(home())
        binding.bottomnavview.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replacewithfrag(home())
                R.id.search -> replacewithfrag(search())
                R.id.profile -> replacewithfrag(profile())
                else ->{
                }
            }
            true
        }

    }
    private fun replacewithfrag(fragment: Fragment){
        val fragmanager = supportFragmentManager
        val fragtransac = fragmanager.beginTransaction()
        fragtransac.replace(R.id.frag,fragment)
        fragtransac.commit()

    }
}