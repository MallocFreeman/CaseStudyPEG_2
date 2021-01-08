package com.example.pegcasestudy2.profile

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pegcasestudy2.R

class ProfileSwipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val profileImage: ImageView = itemView.findViewById(R.id.detailProfileImage)
    private val nameAndAge: TextView = itemView.findViewById(R.id.detailProfileNameAndAge)
    private val location: TextView = itemView.findViewById(R.id.detailProfileLocation)
    private val description: TextView = itemView.findViewById(R.id.detailProfileDescription)

    fun setImageResource(id: Int) {
        profileImage.setImageResource(id)
    }

    fun setLocationText(text: String?) {
        location.text = text
    }

    fun setNameAndAgeText(text: String?) {
        nameAndAge.text = text
    }

    fun setDescription(text: String?) {
        description.text = text
    }
}
