package com.example.pegcasestudy2.activity;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.activity.parcel.ProfileListParcel;
import com.example.pegcasestudy2.activity.parcel.ProfileParcel;
import com.example.pegcasestudy2.fragment.FragmentProfileDetails;
import com.example.pegcasestudy2.fragment.FragmentProfileOverview;
import com.example.pegcasestudy2.profile.OnProfileListener;
import com.example.pegcasestudy2.profile.dao.Profile;
import com.example.pegcasestudy2.profile.repository.ProfileJsonRepository;
import java.util.List;

/**
 * Activity for the overview of all available {@link Profile} objects. Depending on the {@link
 * com.example.pegcasestudy2.profile.repository.ProfileRepository} the content shwon may vary.
 */
public class CaseStudyActivity extends AppCompatActivity implements OnProfileListener {

  private List<Profile> profiles;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mainactivity);
    initProfileInformation();
    switchToProfileOverview();
  }

  @Override
  public void onProfileClick(int id) {
    switchToProfileDetails(id);
  }

  private void initProfileInformation() {
    profiles = new ProfileJsonRepository(getResources(), R.raw.profiles).getProfiles();
  }

  private void switchToProfileOverview() {
    FragmentProfileOverview fragmentProfileOverview = new FragmentProfileOverview(this);
    fragmentProfileOverview.setArguments(
        createBundle(ProfileListParcel.PARCELABLE_LIST_NAME, new ProfileListParcel(profiles)));
    switchFragment(fragmentProfileOverview);
  }

  private void switchToProfileDetails(final int id) {
    FragmentProfileDetails fragmentProfileDetails = new FragmentProfileDetails();
    fragmentProfileDetails.setArguments(
        createBundle(ProfileParcel.PARCELABLE_NAME, new ProfileParcel(profiles.get(id))));
    switchFragment(fragmentProfileDetails);
  }

  private void switchFragment(Fragment fragment) {
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.frame, fragment);
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.commit();
  }

  private Bundle createBundle(String key, Parcelable parcelable) {
    Bundle bundle = new Bundle();
    bundle.putParcelable(key, parcelable);
    return bundle;
  }
}