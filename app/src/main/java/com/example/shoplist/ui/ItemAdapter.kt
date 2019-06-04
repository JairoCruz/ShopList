package com.example.shoplist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplist.R
import com.example.shoplist.database.entity.Item

class ItemAdapter internal constructor(context: Context): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var items = emptyList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = inflater.inflate(R.layout.item_row, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val current = items[position]
        holder.itemTextView.text = current.name
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTextView: TextView = itemView.findViewById(R.id.itemTextView)
    }

    internal fun setItem(items: List<Item>){
        this.items = items
        notifyDataSetChanged()
    }
}