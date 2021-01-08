package com.example.pegcasestudy2.activity;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.fragment.FragmentProfileDetails;
import com.example.pegcasestudy2.fragment.FragmentProfileOverview;
import com.example.pegcasestudy2.parcel.ProfileListParcel;
import com.example.pegcasestudy2.parcel.ProfileParcel;
import com.example.pegcasestudy2.profile.OnProfileListener;

public class CaseStudyActivity extends AppCompatActivity implements OnProfileListener,
    LifecycleOwner {

  private CaseStudyViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mainactivity);
    initViewModel();
    switchToProfileOverview();
  }

  @Override
  public void onProfileClick(int id) {
    switchToProfileDetails(id);
  }

  private void initViewModel() {
    viewModel = new ViewModelProvider(this)
        .get(CaseStudyViewModel.class);
    viewModel.loadProfiles();
  }

  private void switchToProfileOverview() {
    FragmentProfileOverview fragmentProfileOverview = new FragmentProfileOverview(this);
    fragmentProfileOverview.setArguments(
        createBundle(ProfileListParcel.PARCELABLE_LIST_NAME,
            new ProfileListParcel(viewModel.getProfiles())));
    switchFragment(fragmentProfileOverview);
  }

  private void switchToProfileDetails(final int id) {
    FragmentProfileDetails fragmentProfileDetails = new FragmentProfileDetails();
    fragmentProfileDetails.setArguments(
        createBundle(ProfileParcel.PARCELABLE_NAME,
            new ProfileParcel(viewModel.getProfiles().get(id))));
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