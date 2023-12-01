package com.example.listview.adapterlist

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.asses2.R

class ListAdaptor (
    private val context: Activity,
    private val title: Array<String>,
    private val desc: Array<String>

) : ArrayAdapter<String>(context, R.layout.custom_list, title) {

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_view,null)

        // Populate the row view with data
        val detailTitleTextView = view.findViewById<TextView>(R.id.titlebiasa)
        val detailDescriptionTextView = view.findViewById<TextView>(R.id.deskripsibiasa)

        detailTitleTextView.text = title[position]
        detailDescriptionTextView.text = desc[position]


        return view
    }

}