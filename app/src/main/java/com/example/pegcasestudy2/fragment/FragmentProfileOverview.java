package com.example.pegcasestudy2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.parcel.ProfileListParcel;
import com.example.pegcasestudy2.profile.OnProfileListener;
import com.example.pegcasestudy2.profile.ProfileOverviewAdapter;
import com.example.pegcasestudy2.profile.dao.Profile;
import java.util.Collections;
import java.util.List;

public class FragmentProfileOverview extends Fragment {

  private final OnProfileListener onProfileListener;

  public FragmentProfileOverview(OnProfileListener onProfileListener) {
    this.onProfileListener = onProfileListener;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_profile_overview, container, false);

    initRecyclerView(view);
    return view;
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

  private void initRecyclerView(View view) {
    RecyclerView recyclerView = view.findViewById(R.id.profiles);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(new ProfileOverviewAdapter(onProfileListener, readFromBundle()));
  }
}
