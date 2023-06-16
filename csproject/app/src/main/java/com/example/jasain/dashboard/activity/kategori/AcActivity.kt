package com.example.jasain.dashboard.activity.kategori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jasain.R
import com.example.jasain.adapter.KategoriAdapter
import com.example.jasain.dashboard.MainActivity
import com.example.jasain.data.KategoriToko

class AcActivity : AppCompatActivity() {

    private lateinit var kategoriRV: RecyclerView
    private lateinit var kategoriList: ArrayList<KategoriToko>
    lateinit var imgToko: Array<Int>
    lateinit var namaToko: Array<String>
    lateinit var ratingToko: Array<String>
    lateinit var reviewToko: Array<String>
    lateinit var jarakToko: Array<String>
    lateinit var descToko: Array<String>
    lateinit var locToko: Array<String>
    lateinit var telpToko: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ac)

        val btnback = findViewById<ImageView>(R.id.btn_back)
        btnback.setOnClickListener {
            Intent(applicationContext, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        imgToko = arrayOf(
            R.drawable.ac1,
            R.drawable.ac2,
            R.drawable.ac3,
            R.drawable.ac4,
            R.drawable.ac5,
            R.drawable.ac6,
            R.drawable.ac7
        )
        namaToko = arrayOf(
            "AC Care Center",
            "Frosty Air Conditioning",
            "AC Expert",
            "Electronic Solution",
            "Arctic Cool AC Repair",
            "AC Pro Tech",
            "Cool Breeze AC Service"
        )
        ratingToko = arrayOf(
            "4.7/5",
            "4.7/5",
            "4.5/5",
            "4.4/5",
            "4.3/5",
            "3.8/5",
            "3.5/5"
        )
        reviewToko = arrayOf(
            "400 Reviews",
            "300 Reviews",
            "200 Reviews",
            "150 Reviews",
            "100 Reviews",
            "100 Reviews",
            "90 Reviews"
        )
        jarakToko = arrayOf(
            "100 Meter",
            "200 Meter",
            "300 Meter",
            "400 Meter",
            "500 Meter",
            "600 Meter",
            "700 Meter"
        )
        descToko = arrayOf(
            getString(R.string.dsc1),
            getString(R.string.dsc2),
            getString(R.string.dsc3),
            getString(R.string.dsc4),
            getString(R.string.dsc5),
            getString(R.string.dsc6),
            getString(R.string.dsc7)
        )
        locToko = arrayOf(
            getString(R.string.loc1),
            getString(R.string.loc2),
            getString(R.string.loc3),
            getString(R.string.loc4),
            getString(R.string.loc5),
            getString(R.string.loc6),
            getString(R.string.loc7)
        )
        telpToko = arrayOf(
            getString(R.string.telp1),
            getString(R.string.telp2),
            getString(R.string.telp3),
            getString(R.string.telp4),
            getString(R.string.telp5),
            getString(R.string.telp6),
            getString(R.string.telp7),
        )

        kategoriRV = findViewById(R.id.rv_listtoko)
        kategoriRV.layoutManager = LinearLayoutManager(this)
        kategoriRV.setHasFixedSize(true)

        kategoriList = arrayListOf<KategoriToko>()
        getUserdata()
    }

    private fun getUserdata(){
        for (i in imgToko.indices){
            val kategori = KategoriToko(imgToko[i],namaToko[i],ratingToko[i],reviewToko[i],jarakToko[i])
            kategoriList.add(kategori)
        }
        var adapter = KategoriAdapter(kategoriList)
        kategoriRV.adapter = adapter
        adapter.setOnItemClickListener(object : KategoriAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@AcActivity, DetailActivity::class.java)
                intent.putExtra("imgToko",kategoriList[position].img)
                intent.putExtra("namaToko",kategoriList[position].nama)
                intent.putExtra("ratingToko",kategoriList[position].rating)
                intent.putExtra("reviewToko",kategoriList[position].review)
                intent.putExtra("descToko",descToko[position])
                intent.putExtra("locToko",locToko[position])
                intent.putExtra("telpToko",telpToko[position])
                startActivity(intent)
            }
        })
    }
}