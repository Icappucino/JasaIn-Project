package com.example.jasain.dashboard.activity.kategori

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.jasain.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgDetail: ImageView = findViewById(R.id.iv_toko)
        val namaDetail: TextView = findViewById(R.id.tv_toko)
        val ratingDetail: TextView = findViewById(R.id.tv_rating)
        val reviewDetail: TextView = findViewById(R.id.tv_review)
        val descDetail: TextView = findViewById(R.id.tv_isidesc)
        val locDetail: TextView = findViewById(R.id.tv_loctoko)
        val telpDetail: TextView = findViewById(R.id.tv_telptoko)

        val bundle : Bundle?= intent.extras
        val imgToko = bundle!!.getInt("imgToko")
        val namaToko = bundle!!.getString("namaToko")
        val ratingToko = bundle!!.getString("ratingToko")
        val reviewToko = bundle!!.getString("reviewToko")
        val descToko = bundle!!.getString("descToko")
        val locToko = bundle!!.getString("locToko")
        val telpToko = bundle!!.getString("telpToko")

        imgDetail.setImageResource(imgToko)
        namaDetail.text = namaToko
        ratingDetail.text = ratingToko
        reviewDetail.text = reviewToko
        descDetail.text = descToko
        locDetail.text = locToko
        telpDetail.text = telpToko

    }
}