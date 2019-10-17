package com.jonwu.lab_07_android_recyclerview.data

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jonwu.lab_07_android_recyclerview.R
import com.jonwu.lab_07_android_recyclerview.model.Place
import kotlin.coroutines.coroutineContext

class PlaceListAdapter(private val list:ArrayList<Place>, private val context: Context):RecyclerView.Adapter<PlaceListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(place: Place) {
            var country: TextView=itemView.findViewById<TextView>(R.id.country_ID)
            var city: TextView=itemView.findViewById<TextView>(R.id.city_ID)
            country.text = place.CountryName
            city.text = place.CityName
            itemView.setOnClickListener { Toast.makeText(context, country.text, Toast.LENGTH_SHORT).show() }
        }
    }
}