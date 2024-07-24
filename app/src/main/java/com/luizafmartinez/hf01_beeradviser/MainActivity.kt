package com.luizafmartinez.hf01_beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.luizafmartinez.hf01_beeradviser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var findBeer: Button
    private lateinit var beerColor: Spinner
    private lateinit var brands: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        findBeer = binding.findBeer

        binding.findBeer.setOnClickListener {

            beerColor = binding.beerColor

            val color = binding.beerColor.selectedItem

            val beerList = getBeers(color.toString())
            val beers = beerList.reduce { str, item -> str + '\n' + item }

            brands = binding.brands
            brands.text = beers
        }
    }

    fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }

    }
}