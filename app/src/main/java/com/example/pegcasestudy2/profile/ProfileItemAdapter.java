package com.example.pegcasestudy2.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.image.ImageResourceProvider;
import com.example.pegcasestudy2.profile.dao.Profile;
import java.util.List;

public class ProfileItemAdapter extends RecyclerView.Adapter<ProfileViewHolder> {

  private final OnProfileListener onProfileListener;
  private final List<Profile> profiles;

  public ProfileItemAdapter(OnProfileListener onProfileListener, List<Profile> profiles) {
    this.onProfileListener = onProfileListener;
    this.profiles = profiles;
  }

  @NonNull
  @Override
  public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ProfileViewHolder(inflate(parent), onProfileListener);
  }

  @Override
  public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
    Profile profile = profiles.get(position);
    holder.setNameAndAgeText(profile.toString());
    holder.setLocationText(profile.getLocation().toString());
    holder.setImageResource(ImageResourceProvider.provide(profile.getGender()));
  }

  @Override
  public int getItemCount() {
    return profiles.size();
  }

  private View inflate(ViewGroup viewGroup) {
    return LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.profile_item, viewGroup, false);
  }
}
