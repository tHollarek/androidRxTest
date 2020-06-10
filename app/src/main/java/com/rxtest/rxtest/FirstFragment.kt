package com.rxtest.rxtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.FlowableEmitter
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    val presenter = Presenter(this)
    var updatableValue = 1

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.showUpdatableValue()

    }

    fun showValue(value: Int) {
        textview_first.text = value.toString()
    }

    fun registerEmitter(emitter: @NonNull FlowableEmitter<Int>?) {
        button_first.setOnClickListener {
            emitter?.onNext(updatableValue++)
        }
    }
}
