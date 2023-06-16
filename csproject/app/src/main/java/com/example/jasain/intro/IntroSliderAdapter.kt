package com.example.jasain.intro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jasain.R

class IntroSliderAdapter(private val slideModel: List<SlideModel>):
    RecyclerView.Adapter<IntroSliderAdapter.SlideModelViewHolder>(){

    inner class SlideModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textTitle = view.findViewById<TextView>(R.id.tv_Heading)
        private val textDesc = view.findViewById<TextView>(R.id.tv_Desc)
        private val imageIcon = view.findViewById<ImageView>(R.id.iv_Board)

        fun bind(slideModel: SlideModel){
            textTitle.text = slideModel.title
            textDesc.text = slideModel.description
            imageIcon.setImageResource(slideModel.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideModelViewHolder {
        return SlideModelViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.intro_slider,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SlideModelViewHolder, position: Int) {
        holder.bind(slideModel[position])
    }

    override fun getItemCount(): Int {
        return slideModel.size
    }
}