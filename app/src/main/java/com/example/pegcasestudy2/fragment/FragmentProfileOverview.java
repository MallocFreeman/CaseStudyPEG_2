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
import com.example.pegcasestudy2.profile.OnProfileListener;
import com.example.pegcasestudy2.profile.ProfileItemAdapter;
import com.example.pegcasestudy2.profile.dao.Profile;
import com.example.pegcasestudy2.profile.repository.ProfileJsonRepository;
import java.util.List;

public class FragmentProfileOverview extends Fragment {
  private final OnProfileListener onProfileListener;
  private List<Profile> profiles;

  public FragmentProfileOverview(OnProfileListener onProfileListener, List<Profile> profiles) {
    this.onProfileListener = onProfileListener;
    this.profiles = profiles;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_profile_overview, container, false);
    initRecyclerView(view);
    return view;
  }

  private void initRecyclerView(View view) {
    RecyclerView recyclerView = view.findViewById(R.id.profiles);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(new ProfileItemAdapter(onProfileListener, profiles));
  }
}
