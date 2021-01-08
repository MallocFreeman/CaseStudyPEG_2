package com.example.pegcasestudy2.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.image.ImageResourceProvider;
import com.example.pegcasestudy2.profile.dao.Gender;
import com.example.pegcasestudy2.profile.dao.Profile;

public class FragmentViewPager extends Fragment {

  private final Profile profile;

  public FragmentViewPager(Profile profile) {
    super(R.layout.activity_profile_details);
    this.profile = profile;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initViews(view, profile);
  }

  private void initViews(View view, Profile profile) {
    initImageView(view, profile.getGender());
    initTextView(view, R.id.detailProfileNameAndAge, profile.toString());
    initTextView(view, R.id.detailProfileLocation, profile.getLocation().toString());
    initTextView(view, R.id.detailProfileDescription, profile.getDescription());
  }

  private void initImageView(View view, Gender gender) {
    ((ImageView) view.findViewById(R.id.detailProfileImage))
        .setImageResource(ImageResourceProvider.provide(gender));
  }

  private void initTextView(View view, int id, String text) {
    ((TextView) view.findViewById(id)).setText(text);
  }
}