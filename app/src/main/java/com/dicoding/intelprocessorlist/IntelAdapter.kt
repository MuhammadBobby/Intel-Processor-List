package com.dicoding.intelprocessorlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class IntelAdapter : RecyclerView.Adapter<IntelAdapter.IntelViewHolder> () {
    internal var IntelList = arrayListOf<Intel>()

    class IntelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView =itemView.findViewById(R.id.item_title)
        val txtDescription: TextView =itemView.findViewById(R.id.item_description)
        val imgImage: ImageView =itemView.findViewById(R.id.item_image)
        val txtPrice: TextView =itemView.findViewById(R.id.item_price)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IntelAdapter.IntelViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_intel, parent, false)
        return IntelViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: IntelAdapter.IntelViewHolder, position: Int) {
        val (title, description, image, price) = IntelList[position]
        holder.txtTitle.text = title
        holder.txtDescription.text = description
        Glide.with(holder.itemView.context)
            .load(image)
            .into(holder.imgImage)
        holder.txtPrice.text = price
    }

    override fun getItemCount(): Int = IntelList.size
}