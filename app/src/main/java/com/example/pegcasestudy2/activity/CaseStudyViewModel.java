package com.example.pegcasestudy2.activity;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.profile.dao.Profile;
import com.example.pegcasestudy2.profile.repository.ProfileJsonRepository;
import java.util.List;

public class CaseStudyViewModel extends AndroidViewModel {

  private List<Profile> profiles;

  public CaseStudyViewModel(@NonNull Application application) {
    super(application);
  }

  public void loadProfiles() {
    profiles = new ProfileJsonRepository(getApplication().getResources(), R.raw.profiles)
        .getProfiles();
  }

  public List<Profile> getProfiles() {
    return profiles;
  }
}
