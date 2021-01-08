//package com.example.pegcasestudy2.activity;
//
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//
//import android.view.View;
//import android.widget.TextView;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.test.espresso.NoMatchingViewException;
//import androidx.test.espresso.ViewAssertion;
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//import androidx.test.filters.LargeTest;
//import com.example.pegcasestudy2.R;
//import com.example.pegcasestudy2.profile.ProfileItemAdapter;
//import com.example.pegcasestudy2.profile.dao.Gender;
//import com.example.pegcasestudy2.profile.dao.Location;
//import com.example.pegcasestudy2.profile.dao.Profile;
//import java.util.Objects;
//import org.hamcrest.Matchers;
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//@RunWith(AndroidJUnit4.class)
//@LargeTest
//public class CaseStudyActivityTest {
//
//  @Rule
//  public ActivityScenarioRule<CaseStudyActivity> activityScenarioRule =
//      new ActivityScenarioRule<>(CaseStudyActivity.class);
//
//  @Test
//  public void itemCountInRecyclerViewIsCorrect() {
//    onView(withId(R.id.profiles)).check(new RecyclerViewItemCountAssertion(15));
//  }
//
//  @Test
//  public void firstElementShowsCorrectValues() {
//    onView(withId(R.id.profiles)).check(new RecyclerViewElementAssertion(createTestAccount(), 0));
//  }
//
//  private Profile createTestAccount() {
//    return new Profile("Mia", 22, Gender.FEMALE, new Location("Hamburg", "20095"), "");
//  }
//
//  private static abstract class RecyclerViewAssertion implements ViewAssertion {
//
//    RecyclerView getRecyclerView(View view) {
//      if (!(view instanceof RecyclerView)) {
//        throw new IllegalArgumentException("View is not of type RecyclerView");
//      }
//      return (RecyclerView) view;
//    }
//
//    void createErrorIfViewNotFound(NoMatchingViewException noViewFoundException) {
//      if (noViewFoundException != null) {
//        throw noViewFoundException;
//      }
//    }
//
//    ProfileItemAdapter getAdapter(RecyclerView recyclerView) {
//      return (ProfileItemAdapter) recyclerView.getAdapter();
//    }
//  }
//
//  private static class RecyclerViewItemCountAssertion extends RecyclerViewAssertion {
//
//    private final int expectedCount;
//
//    public RecyclerViewItemCountAssertion(int expectedCount) {
//      this.expectedCount = expectedCount;
//    }
//
//    @Override
//    public void check(View view, NoMatchingViewException noViewFoundException) {
//      createErrorIfViewNotFound(noViewFoundException);
//      Assert
//          .assertThat(getAdapter(getRecyclerView(view)).getItemCount(), Matchers.is(expectedCount));
//    }
//  }
//
//  private static class RecyclerViewElementAssertion extends RecyclerViewAssertion {
//
//    private final Profile profile;
//    private final int itemPosition;
//
//    public RecyclerViewElementAssertion(Profile profile, int itemPosition) {
//      this.profile = profile;
//      this.itemPosition = itemPosition;
//    }
//
//    @Override
//    public void check(View view, NoMatchingViewException noViewFoundException) {
//      createErrorIfViewNotFound(noViewFoundException);
//      View itemView = Objects.requireNonNull(getRecyclerView(view).getLayoutManager())
//          .getChildAt(itemPosition);
//      assertOnTextView(getTextView(itemView, R.id.profileNameAndAge), profile.toString());
//      assertOnTextView(getTextView(itemView, R.id.profileLocation),
//          profile.getLocation().toString());
//    }
//
//    private TextView getTextView(View parent, final int resourceID) {
//      return parent.findViewById(resourceID);
//    }
//
//    private void assertOnTextView(TextView textView, String expected) {
//      Assert.assertEquals(expected, textView.getText().toString());
//    }
//  }
//}