package com.example.task6.ui.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.task6.databinding.FragmentTopBinding
import com.example.task6.ui.base.BaseFragment
import com.example.task6.util.FragmentCommunicator
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.ReplaySubject
import java.util.concurrent.TimeUnit

class TopFragment: BaseFragment<FragmentTopBinding>() {
    override val LOG_TAG: String
        get() = "TOP_FRAGMENT"
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTopBinding
        get() = FragmentTopBinding::inflate

    override fun callBacks() {
    }

    override fun setup() {
        val communicator = activity as FragmentCommunicator

        val observable = Observable.create<String> { emitter ->
            binding.textInput.doOnTextChanged { text, start, before, count ->
                emitter.onNext(text.toString())
            }
        }.debounce(1500, TimeUnit.MILLISECONDS)

        val subject = ReplaySubject.create<String>()

        observable.subscribe(subject)

        subject.subscribe({
            communicator.passData(it)
        },
            {
                Log.v("ZAINAB", it.message.toString())
            })
    }
}