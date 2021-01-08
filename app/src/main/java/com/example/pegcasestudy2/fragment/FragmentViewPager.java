package com.example.pegcasestudy2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.parcel.ProfileListParcel;
import com.example.pegcasestudy2.profile.ProfileSwipeAdapter;
import com.example.pegcasestudy2.profile.dao.Profile;
import java.util.Collections;
import java.util.List;

public class FragmentViewPager extends Fragment {

  public static final String CURRENT_POSITION = "currentPosition";

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_profile_swipeview, container, false);

    initViewpager(view);
    return view;
  }

  private void initViewpager(View view) {
    ViewPager2 viewpager = view.findViewById(R.id.viewpager);
    viewpager.setAdapter(new ProfileSwipeAdapter(readFromBundle()));
    viewpager.setCurrentItem(readCurrentPosition(), false);
  }

  private List<Profile> readFromBundle() {
    List<Profile> profiles = Collections.emptyList();

    Bundle bundle = this.getArguments();
    if (bundle != null) {
      ProfileListParcel parcelable = bundle.getParcelable(ProfileListParcel.PARCELABLE_LIST_NAME);
      profiles = parcelable.getProfileList();
    }

    return profiles;
  }

  private int readCurrentPosition() {
    return this.getArguments() != null ? this.getArguments().getInt(CURRENT_POSITION) : 0;
  }
}