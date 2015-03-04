package com.nhaarman.triad;

import com.nhaarman.triad.tests.firstdialog.FirstDialogScreen;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.nhaarman.triad.utils.ViewWaiter.viewHasAlpha;
import static com.nhaarman.triad.utils.ViewWaiter.viewNotPresent;
import static com.nhaarman.triad.utils.ViewWaiter.viewVisible;
import static com.nhaarman.triad.utils.ViewWaiter.waitUntil;
import static org.assertj.android.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class DimmerClickTransitionTest extends TestActivityInstrumentationTestCase {

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    getInstrumentation().runOnMainSync(new Runnable() {
      @Override
      public void run() {
        mFlow.goTo(new FirstDialogScreen());
      }
    });

    waitUntil(viewVisible(mDialogHolder, com.nhaarman.triad.tests.R.id.view_dialog_first));

    onView(withId(com.nhaarman.triad.tests.R.id.view_triad_dimmerview)).perform(click());

    waitUntil(viewNotPresent(mDialogHolder, com.nhaarman.triad.tests.R.id.view_dialog_first));
    waitUntil(viewHasAlpha(mDimmerView, 0f));
  }

  public void test_afterTransition_dialogIsNotPresent() {
    assertThat(mDialogHolder.findViewById(com.nhaarman.triad.tests.R.id.view_dialog_first), is(nullValue()));
  }

  public void test_afterTransition_originalScreenIsPresent() {
    assertThat(mScreenHolder.findViewById(com.nhaarman.triad.tests.R.id.view_screen_first), is(not(nullValue())));
  }

  public void test_afterTransition_dimmerView_isVisible() {
    assertThat(mDimmerView).isVisible();
  }

  public void test_afterTransition_dimmerView_isFullyTranslucent() {
    assertThat((double) mDimmerView.getAlpha(), is(closeTo(0, .0001)));
  }

  public void test_afterTransition_dimmerView_isNotClickable() {
    assertThat(mDimmerView).isNotClickable();
  }

  public void test_afterTransition_dialogHolder_isVisible() {
    assertThat(mDialogHolder).isVisible();
  }
}
