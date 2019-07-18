package com.example.learnespresso;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);//mendefinisikan Activity yang mana yang akan kita uji

    @Test
    public void ensureTextChangeWork(){
        onView(withId(R.id.edtText)).perform(typeText("Hello"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_ganti_text)).perform(click());
        onView(withId(R.id.textText)).check(matches(withText("Lalala")));//untuk menemukan elemen atau komponen antar muka yang diuji.
    }
    @Test
    public void ensureMoveActivityWithData(){
        onView(withId(R.id.edtText)).perform(typeText("DicodingMenjadiAndroidDeveloperExpert"),ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_ganti_act)).perform(click());
        onView(withId(R.id.textAct2)).check(matches(withText("DicodingMenjadiAndroidDeveloperExpert")));
    }

}