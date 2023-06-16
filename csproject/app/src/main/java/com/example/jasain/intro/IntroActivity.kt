package com.example.jasain.intro

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.jasain.R
import com.example.jasain.akun.LoginActivity
import com.example.jasain.dashboard.MainActivity

class IntroActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager2

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            SlideModel(
                "Jadwalkan Service-mu",
                "Perjalanan pelayanan Anda dimulai di sini. Kami membantu Anda menjadwalkan dan menangani masalah elektronik yang Kamu punya.",
                R.drawable.board1
            ),
            SlideModel(
                "Semua Jadi Satu Aplikasi",
                "Dapatkan kemudahan perawatan dan servis berbagai elektronik dengan satu aplikasi di tangan Anda.",
                R.drawable.board2
            ),
            SlideModel(
                "Enjoy kan Harimu",
                "Jadilah bijak dan temukan layanan terbaik anda. Pengalaman bersama kami. Enjoy!",
                R.drawable.board3
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        viewPager = findViewById(R.id.introSliderViewPager)
        viewPager.adapter = introSliderAdapter
        setupSlider()
        setCurrentSlider(0)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentSlider(position)
            }
        })
        val btnStart = findViewById<Button>(R.id.btn_start)
        val txtNext = findViewById<TextView>(R.id.tv_next)
        btnStart.setOnClickListener{
            Intent(applicationContext, MainActivity::class.java).also {
                    startActivity(it)
            }
        }
        txtNext.setOnClickListener{
            if (viewPager.currentItem + 1 < introSliderAdapter.itemCount) {
                viewPager.currentItem += 1
            } else {
                Intent(applicationContext, LoginActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }

    private fun setupSlider(){
        val indicator = findViewById<LinearLayout>(R.id.sliderContainer)
        val slider = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in slider.indices){
            slider[i] = ImageView(applicationContext)
            slider[i].apply {
                this?.setImageDrawable(ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.slider_off
                ))
                this?.layoutParams = layoutParams
            }
            indicator.addView(slider[i])
        }
    }
    private fun setCurrentSlider(index: Int){
        val indicator = findViewById<LinearLayout>(R.id.sliderContainer)
        val childCount = indicator.childCount
        for (i in 0 until childCount){
            val imageView = indicator[i] as ImageView
            if (i == index){
                imageView.setImageDrawable(ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.slider_on
                ))
            }else{
                imageView.setImageDrawable(ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.slider_off
                ))
            }
        }
    }
}