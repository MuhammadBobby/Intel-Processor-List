package com.dicoding.intelprocessorlist

import android.content.Intent
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

        fun bind (intel: Intel) {
            txtTitle.text = intel.title
            txtDescription.text = intel.description
            Glide.with(itemView.context)
                .load(intel.image)
                .into(imgImage)
            txtPrice.text = intel.price

            //proses detail ketika di klik
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailListActivity::class.java)
                intent.putExtra(DetailListActivity.KEY_INTEL_LIST, intel)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IntelAdapter.IntelViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_intel, parent, false)
        return IntelViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: IntelAdapter.IntelViewHolder, position: Int) {
        holder.bind(IntelList[position]) //ngambil fun bind dari holder atas
    }

    override fun getItemCount(): Int = IntelList.size
}