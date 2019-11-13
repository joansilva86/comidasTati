package com.example.comidastati.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.comidastati.R
import kotlinx.android.synthetic.main.recycler_item.view.*

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    private  var list = ArrayList<RecyclerModel>()

    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return MyViewHolder(v)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){
        fun bind(model: RecyclerModel){
            view.txtName.text = model.name
        }
    }
}