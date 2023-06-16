package com.example.jasain.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.jasain.R
import com.example.jasain.dashboard.activity.kategori.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnall = findViewById<CardView>(R.id.btn_all)
        val btnac = findViewById<CardView>(R.id.btn_ac)
        val btnhp = findViewById<CardView>(R.id.btn_hp)
        val btnlaptop = findViewById<CardView>(R.id.btn_laptop)
        val btnpc = findViewById<CardView>(R.id.btn_komputer)
        val btnprinter = findViewById<CardView>(R.id.btn_printer)

        btnall.setOnClickListener {
            Intent(applicationContext, AllActivity::class.java).also {
                startActivity(it)
            }
        }
        btnac.setOnClickListener {
            Intent(applicationContext, AcActivity::class.java).also {
                startActivity(it)
            }
        }
        btnhp.setOnClickListener {
            Intent(applicationContext, HpActivity::class.java).also {
                startActivity(it)
            }
        }
        btnlaptop.setOnClickListener {
            Intent(applicationContext, LaptopActivity::class.java).also {
                startActivity(it)
            }
        }
        btnpc.setOnClickListener {
            Intent(applicationContext, KomputerActivity::class.java).also {
                startActivity(it)
            }
        }
        btnprinter.setOnClickListener {
            Intent(applicationContext, PrinterActivity::class.java).also {
                startActivity(it)
            }
        }

        val imgList = ArrayList<SlideModel>()
        imgList.add(SlideModel("https://suwun.co.id/blog/wp-content/uploads/2022/02/jasa-service.jpg","Repair your computer"))
        imgList.add(SlideModel("https://pingpoint.co.id/media/images/KELAPA_GADING_PROPERTI_INI_5_ALASAN_MENGAPA_AND.original.jpg","Repair your ac"))
        imgList.add(SlideModel("https://cdn.ajnn.net/files/images/20210323-img-20210323-221546.jpg","Repair your phone"))
        imgList.add(SlideModel("https://ekakom.com/wp-content/uploads/2018/03/Service-Laptop-Computer-Printer-Depok-1-1080x675.jpg","Repair your laptop"))
        imgList.add(SlideModel("https://betanews.id/wp-content/uploads/2020/09/20200924_BETANEWS_KU_TRIK-PRINTER-02.jpg","Repair your printer"))

        val imgSlider = findViewById<ImageSlider>(R.id.img_slider)
        imgSlider.setImageList(imgList)

        val navigation: BottomNavigationView = findViewById(R.id.bottomNav)
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.order -> {
                    val intent = Intent(this, OrderActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.bot -> {
                    val intent = Intent(this, BotActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}