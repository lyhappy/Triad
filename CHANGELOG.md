# Changelog

Version 0.19.0 *(2016-04-29)*
-----------------------------------

 * Use JvmStatics where possible.

Version 0.18.4 *(2016-04-13)*
-----------------------------------

 * Removed extraneous logging statements.

Version 0.18.3 *(2016-04-05)*
-----------------------------------

 * Propagate lifecycle events in AppCompat activities as well.

Version 0.18.2 *(2016-04-05)*
-----------------------------------

 * Added `onAttach(Activity)` and `onDetach(Activity)` lifecycle events.
 * Only call `Screen.onDestroy()` when Activity is finishing.


Version 0.18.1 *(2016-03-28)*
-----------------------------------

 * Upgraded Kotlin version to 1.0.1.
 * Allow a TransitionAnimator to be used in startWith().
 * Use a View in favor of a ViewGroup for root views.

Version 0.18.0 *(2016-02-04)*
-----------------------------------

 * Upgraded Kotlin version to rc-1036.

Version 0.17.0 *(2016-01-21)*
-----------------------------------

 * Created dedicated Kotlin modules.

Version 0.16.0 *(2016-01-06)*
-----------------------------------

 * Screens are notified of creation and destroy.

Version 0.15.1 *(2015-12-15)*
-----------------------------------

 * Presenters are retrieved lazily.

Version 0.15.0 *(2015-11-12)*
-----------------------------------

 * Extracted `Presenter` to an interface, classes can extend `BasePresenter` now.
 * Improved animation API.
 * View state is saved when navigating to a new screen.

Version 0.14.1 *(2015-10-30)*
-----------------------------------

 * Fixed crash on creating Presenter.


Version 0.14.0 *(2015-10-29)*
-----------------------------------

 * Use view ids as a reference for creating presenters instead of a class.

Version 0.13.2 *(2015-10-27)*
-----------------------------------

 * Performance improvements


Version 0.13.1 *(2015-10-27)*
-----------------------------------

 * Fixed recycling issue in `AdapterRelativeLayoutContainer`.

Version 0.13.0 *(2015-10-25)*
-----------------------------------

 * Removed `getTriad()` from `Presenter` in favor of dependency injection.
 * `RelativeLayoutContainer`, `ListViewContainer` and `AdapterRelativeLayoutContainer` don't require third `Container` type parameter anymore.
 * Use a more intuitive order of generic type parameters.
 * Fixed crash in design tools.

Version 0.12.0 *(2015-10-17)*
-----------------------------------

 * Container views now request an instance of their Presenter on their own using the Screen;
 * Added an `AdapterRelativeLayoutContainer` for use with `ListViews`.

Version 0.11.2 *(2015-08-27)*
-----------------------------------

 * Set Triad instance to drawer presenter

Version 0.11.1 *(2015-08-25)*
-----------------------------------

 * Fixed bug where presenter would not gain control over container
 * Created `ContainerDelegate`.

Version 0.11.0 *(2015-08-09)*
-----------------------------------

 * Added option to wrap a screen's Context

Version 0.10.0 *(2015-08-09)*
-----------------------------------

 * Removed distinction between Presenter and ScreenPresenter

Version 0.9.0 *(2015-08-05)*
-----------------------------------

 * Explicitely use ApplicationComponent and ActivityComponent

Version 0.8.1 *(2015-08-02)*
-----------------------------------

 * Added DrawerScreen
 * Removed keyboard manipulation

Version 0.8.0 *(2015-07-20)*
-----------------------------------

 * Created a way to start Activities with `Triad`
 * Created a way to manage screen transitions

Version 0.7.1 *(2015-07-18)*
-----------------------------------

 * Updated `TriadAppCompatActivity`

Version 0.7.0 *(2015-07-11)*
-----------------------------------

 * Made `Presenter.getContainer()` return `Optional` instance.
 * Updated ButterKnife
 * Bugfixes

Version 0.6.0 *(2015-07-06)*
-----------------------------------

 * Use a custom version of Flow (now called Triad)
 * Code cleanup and optimizations
 * Don't require to specify an initial screen on startup

Version 0.5.1 *(2015-06-20)*
-----------------------------------

 * Made `FlowManager` public.
 * Code cleanup and optimizations

Version 0.5.0 *(2015-06-17)*
-----------------------------------

 * Removed dialogs to make place for a better implementation;
 * Made `TriadDelegate` public.


Version 0.4.0 *(2015-04-23)*
-----------------------------------

 * Use the new `AppCompatActivity` instead of `ActionBarActivity`;
 * Made `RelativeLayoutContainer` constructors public.

Version 0.3.0 *(2015-04-05)*
-----------------------------------

 * Provided `Flow` instance to `Presenters`
 * Added `OnScreenChangedListener`
 * Added `triad-appcompat-v7` which includes `TriadActionBarActivity`

Version 0.2.2 *(2015-03-30)*
-----------------------------------

 * Support API 14
 * Presenters will now receive a call to onControlLost when the Activity's onStop method is called


Version 0.2.1 *(2015-03-04)*
-----------------------------------

 * Fixed crash on devices running KitKat or lower
 * Moved screen initialization from onStart() to onPostCreate()
 * Fixed bug in sample application

Version 0.2.0 *(2015-02-25)*
-----------------------------------

 * Created sample application

Version 0.1.0 *(2015-02-22)*
-----------------------------------

 * First 0.x release.
