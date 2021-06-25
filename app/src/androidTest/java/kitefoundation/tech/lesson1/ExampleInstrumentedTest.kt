package kitefoundation.tech.lesson1

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    public val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun init() {
        activityTestRule.activity.supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainNavhost, DashboardFragment())
            commit()
        }
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("kitefoundation.tech.lesson1", appContext.packageName)
    }

    @Test
    fun isTextViewBeingDisplayed() {
        onView(withId(R.id.dashboardText)).check(matches(isDisplayed()))
    }

    @Test
    fun isNotificationButtonClickable() {
        onView(withId(R.id.raiseNotifications)).check(matches(isDisplayed()))
        onView(withId(R.id.raiseNotifications)).perform(click())
    }
}