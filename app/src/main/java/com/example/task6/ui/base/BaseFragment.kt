package com.example.task6.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>: Fragment() {
    protected abstract val LOG_TAG: String
    protected abstract val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> VB
    private lateinit var _binding: VB
    protected val binding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container, false)
        setup()
        callBacks()
        return binding.root
    }

    abstract fun callBacks()

    abstract fun setup()

    protected fun log(value: Any){
        Log.v(LOG_TAG, value.toString())
    }
}