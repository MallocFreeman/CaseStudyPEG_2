package com.example.pegcasestudy2.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pegcasestudy2.R
import com.example.pegcasestudy2.image.ImageResourceProvider
import com.example.pegcasestudy2.profile.dao.Profile

class ProfileSwipeAdapter(private val profiles: List<Profile>) : RecyclerView.Adapter<ProfileSwipeViewHolder>() {
    override fun getItemCount(): Int {
        return profiles.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileSwipeViewHolder {
        return ProfileSwipeViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_profile_details, parent, false))
    }

    override fun onBindViewHolder(holder: ProfileSwipeViewHolder, position: Int) {
        val profile = profiles[position]
        holder.setNameAndAgeText(profile.toString())
        holder.setDescription(profile.description)
        holder.setLocationText(profile.location.toString())
        holder.setImageResource(ImageResourceProvider.provide(profile.gender))
    }
}
