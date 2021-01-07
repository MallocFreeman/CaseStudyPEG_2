package com.example.pegcasestudy2.profile;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pegcasestudy2.R;

public class ProfileViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

  private final ImageView profileImage;
  private final TextView nameAndAge;
  private final TextView location;

  private final OnProfileListener onProfileListener;

  public ProfileViewHolder(@NonNull View itemView, @NonNull OnProfileListener onProfileListener) {
    super(itemView);
    profileImage = itemView.findViewById(R.id.profilePicture);
    nameAndAge = itemView.findViewById(R.id.profileNameAndAge);
    location = itemView.findViewById(R.id.profileLocation);
    this.onProfileListener = onProfileListener;

    itemView.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    onProfileListener.onProfileCLick(getAdapterPosition());
  }

  void setImageResource(final int id) {
    profileImage.setImageResource(id);
  }

  void setLocationText(String text) {
    location.setText(text);
  }

  void setNameAndAgeText(String text) {
    nameAndAge.setText(text);
  }
}
