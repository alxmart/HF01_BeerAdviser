package com.luizafmartinez.hf01_beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var findBeer : Button
    private lateinit var beerColor: Spinner
    private lateinit var brands: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findBeer = findViewById(R.id.find_beer)

        findBeer.setOnClickListener {

            beerColor = findViewById(R.id.beer_color)
            val color = beerColor.selectedItem

            val beerList = getBeers(color.toString())
            val beers =beerList.reduce { str, item -> str + '\n' + item  }

            brands = findViewById(R.id.brands)
            brands.text = beers
        }
    }

    fun getBeers(color: String) : List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else    -> listOf("Gout Stout", "Dark Daniel")
        }

    }












}