package com.example.calculatorapp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class CalculationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityScenarioRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void addTwoNumbers() {
        onView(withId(R.id.btn_two)).perform(click());
        onView(withId(R.id.btn_plus)).perform(click());
        onView(withId(R.id.btn_three)).perform(click());
        onView(withId(R.id.btn_equalsto)).perform(click());
        onView(withId(R.id.edt_calculation)).check(matches(withText("5")));


    }

    @Test
    public void subtractTwoNumbers() {
        onView(withId(R.id.btn_eight)).perform(click());
        onView(withId(R.id.btn_minus)).perform(click());
        onView(withId(R.id.btn_three)).perform(click());
        onView(withId(R.id.btn_equalsto)).perform(click());
        onView(withId(R.id.edt_calculation)).check(matches(withText("5.0")));

    }

    @Test
    public void multiplyTwoNumbers() {
        onView(withId(R.id.btn_eight)).perform(click());
        onView(withId(R.id.btn_multiply)).perform(click());
        onView(withId(R.id.btn_three)).perform(click());
        onView(withId(R.id.btn_equalsto)).perform(click());
        onView(withId(R.id.edt_calculation)).check(matches(withText("24.0")));
    }

    @Test
    public void divideTwoNumbers() {
        onView(withId(R.id.btn_nine)).perform(click());
        onView(withId(R.id.btn_divide)).perform(click());
        onView(withId(R.id.btn_three)).perform(click());
        onView(withId(R.id.btn_equalsto)).perform(click());
        onView(withId(R.id.edt_calculation)).check(matches(withText("3.0")));
    }

    @Test
    public void calculatePercentage() {
        onView(withId(R.id.btn_three)).perform(click());
        onView(withId(R.id.btn_percentage)).perform(click());
        onView(withId(R.id.edt_calculation)).check(matches(withText("0.03")));
    }
}