package com.example.tictactoe.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tictactoe.Home
import com.example.tictactoe.R
import com.example.tictactoe.login
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(




        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.texthome)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })


        view?.findViewById<Button>(R.id.tttbt)?.setOnClickListener {

            val i = Intent(activity, login::class.java)
            activity?.startActivity(i)
            startActivity(i)
        }

        return root

    }


}