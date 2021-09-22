package com.example.task6.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.task6.R
import com.example.task6.databinding.ActivityMainBinding
import com.example.task6.ui.fragments.BottomFragment
import com.example.task6.ui.fragments.TopFragment
import com.example.task6.util.Constants
import com.example.task6.util.FragmentCommunicator

class MainActivity : AppCompatActivity(), FragmentCommunicator {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSubView(TopFragment(), R.id.container_fragment_top)
        initSubView(BottomFragment(), R.id.container_fragment_bottom)
    }

    private fun initSubView(fragment: Fragment, fragmentContainerId: Int) {
        supportFragmentManager.beginTransaction().apply {
            add(fragmentContainerId, fragment)
            commit()
        }
    }

    override fun passData(inputText: String) {
        val bundle = Bundle()
        bundle.putString(Constants.BUNDLE_KEY, inputText)

        supportFragmentManager.beginTransaction().apply {
            val fragment = BottomFragment()
            fragment.arguments = bundle
            replace(R.id.container_fragment_bottom, fragment)
            commit()
        }
    }

}