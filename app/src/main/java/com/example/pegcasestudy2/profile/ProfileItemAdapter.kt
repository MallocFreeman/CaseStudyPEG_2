package com.example.pegcasestudy2.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pegcasestudy2.R
import com.example.pegcasestudy2.image.ImageResourceProvider
import com.example.pegcasestudy2.profile.dao.Profile

/**
 * Adapter class that takes care of providing the data for a [RecyclerView] with [Profile] objects.
 */
class ProfileItemAdapter(private val onProfileListener: OnProfileListener, private val profiles: List<Profile>) : RecyclerView.Adapter<ProfileViewHolder>() {

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = profiles[position]
        holder.setNameAndAgeText(profile.toString())
        holder.setLocationText(profile.location.toString())
        holder.setImageResource(ImageResourceProvider.provide(profile.gender))
    }

    override fun getItemCount(): Int = profiles.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder = ProfileViewHolder(inflate(parent), onProfileListener)

    private fun inflate(viewGroup: ViewGroup): View = LayoutInflater.from(viewGroup.context).inflate(R.layout.profile_item, viewGroup, false)

}
