package com.gustavo.desafio_android.ui.main.activity


import android.os.SystemClock
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.gustavo.desafio_android.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class PullRequestListFragmentTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testViewHolderClickAndSentToAnotherActivity() {
        val recyclerView = onView(
            allOf(
                withId(R.id.recyclerview_repository),
                childAtPosition(
                    withId(R.id.main),
                    0
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        val recyclerView2 = onView(
            allOf(
                withId(R.id.recyclerview_pull_request),
                childAtPosition(
                    withId(R.id.main),
                    0
                )
            )
        )
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(0, click()))
    }

    @Test
    fun testViewHolderRepositoryNameIsDisplayed() {
        SystemClock.sleep(10000);
        val recyclerView = onView(
            allOf(
                withId(R.id.recyclerview_repository),
                childAtPosition(
                    withId(R.id.main),
                    0
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))
        SystemClock.sleep(10000);
        onView(hasItemAtPosition(3, ViewMatchers.hasDescendant(ViewMatchers.withText("Serialization bugs")))).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed())
        );
    }

    fun hasItemAtPosition(position: Int, matcher: Matcher<View>) : Matcher<View> {
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {

            override fun describeTo(description: Description?) {
                description?.appendText("has item at position $position : ")
                matcher.describeTo(description)
            }

            override fun matchesSafely(item: RecyclerView?): Boolean {
                val viewHolder = item?.findViewHolderForAdapterPosition(position)
                return matcher.matches(viewHolder?.itemView)
            }
        }
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
