package androidsamples.java.whatday;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented tests for the {@link MainActivity} behavior.
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTests {
  @Rule
  public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

  @Test
  public void Aug15_1947_Friday() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("15"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("8"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("1947"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Friday")));
  }

  @Test
  public void test42isInvalidDate() {
    onView(withId(R.id.editDate)).perform(clearText(), typeText("42"));
    onView(withId(R.id.editMonth)).perform(clearText(), typeText("8"));
    onView(withId(R.id.editYear)).perform(clearText(), typeText("2021"));

    onView(withId(R.id.btn_check)).perform(click());

    onView(withId(R.id.txt_display)).check(matches(withText("Invalid date")));
  }
}