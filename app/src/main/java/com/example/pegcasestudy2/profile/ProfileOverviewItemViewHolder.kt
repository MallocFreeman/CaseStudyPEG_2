package com.example.pegcasestudy2.profile

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pegcasestudy2.R

class ProfileOverviewItemViewHolder(itemView: View, onProfileListener: OnProfileListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private val profileImage: ImageView = itemView.findViewById(R.id.profilePicture)
    private val nameAndAge: TextView = itemView.findViewById(R.id.profileNameAndAge)
    private val location: TextView = itemView.findViewById(R.id.profileLocation)
    private val onProfileListener: OnProfileListener = onProfileListener

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View) = onProfileListener.onProfileClick(adapterPosition)

    fun setImageResource(id: Int) {
        profileImage.setImageResource(id)
    }

    fun setLocationText(text: String?) {
        location.text = text
    }

    fun setNameAndAgeText(text: String?) {
        nameAndAge.text = text
    }
}
