package com.example.pegcasestudy2.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.activity.parcel.ProfileParcel;
import com.example.pegcasestudy2.profile.OnProfileListener;
import com.example.pegcasestudy2.profile.ProfileItemAdapter;
import com.example.pegcasestudy2.profile.dao.Profile;
import com.example.pegcasestudy2.profile.repository.ProfileJsonRepository;
import java.util.List;

/**
 * Activity for the overview of all available {@link Profile} objects. Depending on the {@link
 * com.example.pegcasestudy2.profile.repository.ProfileRepository} the content shwon may vary.
 */
public class ProfileOverviewActivity extends AppCompatActivity implements OnProfileListener {

  private List<Profile> profiles;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile_overview);
    initProfileInformation();
    initRecyclerView();
  }

  @Override
  public void onProfileClick(int id) {
    switchToProfileDetails(id);
  }

  private void initProfileInformation() {
    profiles = new ProfileJsonRepository(getResources(), R.raw.profiles).getProfiles();
  }

  private void initRecyclerView() {
    RecyclerView recyclerView = findViewById(R.id.profiles);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(new ProfileItemAdapter(this, profiles));
  }

  private void switchToProfileDetails(int id) {
    Intent profileDetailsIntent = new Intent(this, ProfileDetailsActivity.class);
    profileDetailsIntent
        .putExtra(ProfileParcel.PARCELABLE_NAME, new ProfileParcel(profiles.get(id)));
    profileDetailsIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
    startActivity(profileDetailsIntent);
  }
}