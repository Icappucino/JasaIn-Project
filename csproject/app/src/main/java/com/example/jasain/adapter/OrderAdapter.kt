package com.example.jasain.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jasain.R
import com.example.jasain.data.Order

class OrderAdapter(private val orderList: ArrayList<Order>):
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    class OrderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtnama: TextView = itemView.findViewById(R.id.tv_toko)
        val txttanggal: TextView = itemView.findViewById(R.id.tv_tgl)
        val txtjasa: TextView = itemView.findViewById(R.id.tv_orderjasa)
        val txtbiaya: TextView = itemView.findViewById(R.id.tv_total)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val list = orderList[position]
        holder.txtnama.text = list.nama
        holder.txttanggal.text = list.tanggal
        holder.txtjasa.text = list.jasa
        holder.txtbiaya.text = list.biaya
    }

    override fun getItemCount(): Int {
        return orderList.size
    }
}