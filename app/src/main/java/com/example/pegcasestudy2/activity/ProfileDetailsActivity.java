package com.example.pegcasestudy2.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.activity.parcel.ProfileParcel;
import com.example.pegcasestudy2.image.ImageResourceProvider;
import com.example.pegcasestudy2.profile.dao.Gender;
import com.example.pegcasestudy2.profile.dao.Profile;

/**
 * Activity for the detail view of a {@link Profile}
 */
public class ProfileDetailsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile_details);
    initViews(readProfileFromIntent());
  }

  private Profile readProfileFromIntent() {
    return ((ProfileParcel) getIntent().getParcelableExtra(ProfileParcel.PARCELABLE_NAME))
        .getProfile();
  }

  private void initViews(Profile profile) {
    initImageView(profile.getGender());
    initTextView(R.id.detailProfileNameAndAge, profile.toString());
    initTextView(R.id.detailProfileLocation, profile.getLocation().toString());
    initTextView(R.id.detailProfileDescription, profile.getDescription());
  }

  private void initImageView(Gender gender) {
    ImageView imageView = findViewById(R.id.detailProfileImage);
    int imageResource = ImageResourceProvider.provide(gender);
    imageView.setImageResource(imageResource);
    imageView.setTag(imageResource);
  }

  private void initTextView(int id, String text) {
    ((TextView) findViewById(id)).setText(text);
  }
}