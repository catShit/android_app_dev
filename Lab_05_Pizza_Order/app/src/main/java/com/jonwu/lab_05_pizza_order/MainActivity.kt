package com.jonwu.lab_05_pizza_order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onPlaceOrderButtonClicked(view: View) {
        var pizzaSizePrice = 0.0
        var toppingsTotal = 0.0
        when {
            radioGroup.smallpizza.isChecked -> pizzaSizePrice = 5.0
            radioGroup.mediumpizza.isChecked -> pizzaSizePrice = 7.0
            radioGroup.largepizza.isChecked -> pizzaSizePrice = 9.0
        }

        if (OnionsCheckBox.isChecked) {
            toppingsTotal += 1.0
        }
        if (OlivesCheckBox.isChecked) {
            toppingsTotal += 2.0
        }
        if (TomatosCheckBox.isChecked) {
            toppingsTotal += 3.0
        }

        TotalPrice.text = "Total Order Price = $ " + (pizzaSizePrice + toppingsTotal)
    }
}
