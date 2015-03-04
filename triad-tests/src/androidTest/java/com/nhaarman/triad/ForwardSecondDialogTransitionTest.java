package com.nhaarman.triad;

import com.nhaarman.triad.tests.firstdialog.FirstDialogScreen;
import com.nhaarman.triad.tests.seconddialog.SecondDialogScreen;

import static com.nhaarman.triad.utils.ViewWaiter.viewVisible;
import static com.nhaarman.triad.utils.ViewWaiter.waitUntil;
import static org.assertj.android.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class ForwardSecondDialogTransitionTest extends TestActivityInstrumentationTestCase {

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

    getInstrumentation().runOnMainSync(new Runnable() {
      @Override
      public void run() {
        mFlow.goTo(new SecondDialogScreen());
      }
    });

    waitUntil(viewVisible(mDialogHolder, com.nhaarman.triad.tests.R.id.view_dialog_second));
  }

  public void test_afterTransition_dialogHasBeenAdded() {
    assertThat(mDialogHolder.findViewById(com.nhaarman.triad.tests.R.id.view_dialog_second), is(not(nullValue())));
  }

  public void test_afterTransition_originalScreenIsPresent() {
    assertThat(mScreenHolder.findViewById(com.nhaarman.triad.tests.R.id.view_screen_first), is(not(nullValue())));
  }

  public void test_afterTransition_firstDialogIsPresent() {
    assertThat(mDialogHolder.findViewById(com.nhaarman.triad.tests.R.id.view_dialog_first), is(not(nullValue())));
  }

  public void test_afterTransition_dimmerView_isVisible() {
    assertThat(mDimmerView).isVisible();
  }

  public void test_afterTransition_dimmerView_isNotFullyTranslucent() {
    assertThat((double) mDimmerView.getAlpha(), is(closeTo(.5, .0001)));
  }

  public void test_afterTransition_dimmerView_isClickable() {
    assertThat(mDimmerView).isClickable();
  }

  public void test_afterTransition_dialogHolder_isVisible() {
    assertThat(mDialogHolder).isVisible();
  }
}
