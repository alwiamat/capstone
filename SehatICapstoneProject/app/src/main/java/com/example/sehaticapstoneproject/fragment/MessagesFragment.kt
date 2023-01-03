package com.example.sehaticapstoneproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sehaticapstoneproject.R
import com.example.sehaticapstoneproject.viewmodel.MessagesViewModel

class MessagesFragment : Fragment() {

    private lateinit var messagesViewModel: MessagesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        messagesViewModel =
            ViewModelProvider(this).get(
                MessagesViewModel::class.java)
        val root = inflater.inflate(
            R.layout.fragment_messages, container, false)
        val textView: TextView = root.findViewById(R.id.text_messages)
        messagesViewModel.text.observe(
            viewLifecycleOwner, Observer {
                textView.text = it
            })
        return root
    }
}