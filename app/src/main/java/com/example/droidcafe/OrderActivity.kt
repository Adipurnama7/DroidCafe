package com.example.droidcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast


class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Ambil Spinner dari layout
        val citySpinner: Spinner = findViewById(R.id.city)

        // Set listener untuk Spinner
        citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedCity = parent.getItemAtPosition(position).toString()
                displayToast("Kota yang dipilih: $selectedCity")
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Tidak ada yang dipilih
                // Tidak ada yang dipilih
                // Tidak ada yang dipilih
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        // Cek apakah tombol dipilih
        val checked = (view as RadioButton).isChecked
        when (view.id) {
            R.id.sameday -> if (checked)
                displayToast(getString(R.string.same_day_messenger_service))
            R.id.nextday -> if (checked)
                displayToast(getString(R.string.next_day_ground_delivery))
            R.id.pickup -> if (checked)
                displayToast(getString(R.string.pick_up))
            else -> {}
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}