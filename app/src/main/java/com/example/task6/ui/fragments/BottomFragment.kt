package com.example.task6.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.task6.databinding.FragmentBottomBinding
import com.example.task6.ui.base.BaseFragment
import com.example.task6.util.Constants

class BottomFragment: BaseFragment<FragmentBottomBinding>() {
    override val LOG_TAG: String
        get() = "BOTTOM_FRAGMENT"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentBottomBinding
        get() = FragmentBottomBinding::inflate

    override fun callBacks() {
    }

    override fun setup() {
        val displayText = arguments?.getString(Constants.BUNDLE_KEY)
        binding.viewTextInput.text = displayText
    }
}