package com.example.pegcasestudy2.activity;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.fragment.FragmentProfileOverview;
import com.example.pegcasestudy2.fragment.FragmentViewPager;
import com.example.pegcasestudy2.parcel.ProfileListParcel;
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
    switchToViewPager(id);
  }

  private void initViewModel() {
    viewModel = new ViewModelProvider(this).get(CaseStudyViewModel.class);
    viewModel.loadProfiles();
  }

  private void switchToProfileOverview() {
    switchFragment(new FragmentProfileOverview(this),
        createBundle(ProfileListParcel.PARCELABLE_LIST_NAME,
            new ProfileListParcel(viewModel.getProfiles())));
  }

  private void switchToViewPager(final int id) {
    Bundle bundle = createBundle(ProfileListParcel.PARCELABLE_LIST_NAME,
        new ProfileListParcel(viewModel.getProfiles()));
    bundle.putInt(FragmentViewPager.CURRENT_POSITION, id);
    switchFragment(new FragmentViewPager(), bundle);
  }

  private void switchFragment(Fragment fragment, Bundle bundle) {
    fragment.setArguments(bundle);
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