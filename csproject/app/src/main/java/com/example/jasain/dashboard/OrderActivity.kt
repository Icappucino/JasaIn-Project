package com.example.jasain.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jasain.R
import com.example.jasain.adapter.OrderAdapter
import com.example.jasain.data.Order

class OrderActivity : AppCompatActivity() {

    private lateinit var orderView: RecyclerView
    private lateinit var listOrder: ArrayList<Order>
    private lateinit var orderAdapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        listOrder = ArrayList()

        orderView = findViewById(R.id.rv_order)
        orderView.setHasFixedSize(true)
        orderView.layoutManager = LinearLayoutManager(this)

        orderAdapter = OrderAdapter(listOrder)
        orderView.adapter = orderAdapter

        listOrder.add(Order("AC Care Center","23 Mei 2023","Cuci AC 0.5 - 1 PK", "Rp 75.000"))
        listOrder.add(Order("Frosty Air Conditioning","23 Mei 2023","Cuci AC Inverter 0.5 - 2 PK", "Rp 130.000"))
        listOrder.add(Order("Electronic Solution","23 Mei 2023","Isi Freon R22  1.5 - 2 PK", "Rp 300.000"))

        val btnback = findViewById<ImageView>(R.id.btn_back)
        btnback.setOnClickListener {
            Intent(applicationContext, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}