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
class ProfileOverviewAdapter(private val onProfileListener: OnProfileListener, private val profiles: List<Profile>) : RecyclerView.Adapter<ProfileOverviewItemViewHolder>() {

    override fun onBindViewHolder(holderOverviewItem: ProfileOverviewItemViewHolder, position: Int) {
        val profile = profiles[position]
        holderOverviewItem.setNameAndAgeText(profile.toString())
        holderOverviewItem.setLocationText(profile.location.toString())
        holderOverviewItem.setImageResource(ImageResourceProvider.provide(profile.gender))
    }

    override fun getItemCount(): Int = profiles.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileOverviewItemViewHolder = ProfileOverviewItemViewHolder(inflate(parent), onProfileListener)

    private fun inflate(viewGroup: ViewGroup): View = LayoutInflater.from(viewGroup.context).inflate(R.layout.profile_item, viewGroup, false)

}
