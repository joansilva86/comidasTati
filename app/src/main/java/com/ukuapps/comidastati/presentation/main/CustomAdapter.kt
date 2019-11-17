package com.ukuapps.comidastati.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ukuapps.comidastati.R
import kotlinx.android.synthetic.main.recycler_item.view.*

class CustomAdapter (var listener: ListenerRecyclerClick) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

     var list = ArrayList<RecyclerModel>()

    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return MyViewHolder(v, listener)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class MyViewHolder(var view: View, var listener: ListenerRecyclerClick) : RecyclerView.ViewHolder(view){
        init {
            this.view.setOnClickListener{listener}
        }
        fun bind(model: RecyclerModel){
            view.txtName.text = model.name
        }
    }
}

interface ListenerRecyclerClick {
    fun onClick(id: Int)

}