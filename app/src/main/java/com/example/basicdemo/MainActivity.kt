package com.example.basicdemo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydemosample.HeroesAdapterKot
import com.example.mydemosample.HeroesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var adapter: HeroesAdapterKot
    val myViewModel: HeroesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.setLayoutManager(LinearLayoutManager(this))

        requestButton.setOnClickListener {
            it.visibility = View.GONE
            myViewModel.fetchData()
        }
        setupObservers()
    }

    private fun setupObservers() {

        myViewModel.heroes.observe(this, Observer {
            it?.let {
                adapter = HeroesAdapterKot(this@MainActivity, myViewModel, it)
                recyclerview.setAdapter(adapter)
            }
        })

        myViewModel.myPosition.observe(this, Observer {
            Toast.makeText(this, "Name ::" + it, Toast.LENGTH_SHORT).show()
        })
    }
}