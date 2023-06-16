package com.example.jasain.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jasain.R
import com.example.jasain.data.KategoriToko

class KategoriAdapter(private val Tokolist: ArrayList<KategoriToko>) :
    RecyclerView.Adapter<KategoriAdapter.TokoViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }


        class TokoViewHolder(itemView : View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
            val img: ImageView = itemView.findViewById(R.id.iv_toko)
            val nama: TextView = itemView.findViewById(R.id.tv_toko)
            val rating: TextView = itemView.findViewById(R.id.tv_rating)
            val review: TextView = itemView.findViewById(R.id.tv_review)
            val jarak: TextView = itemView.findViewById(R.id.tv_jaraktoko)

            init {
                itemView.setOnClickListener {
                    listener.onItemClick(adapterPosition)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TokoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_toko, parent, false)
        return TokoViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: TokoViewHolder, position: Int) {
        val kategoriItem = Tokolist[position]
        holder.img.setImageResource(kategoriItem.img)
        holder.nama.text = kategoriItem.nama
        holder.rating.text = kategoriItem.rating
        holder.review.text = kategoriItem.review
        holder.jarak.text = kategoriItem.jarak
    }

    override fun getItemCount(): Int {
        return Tokolist.size
    }
}