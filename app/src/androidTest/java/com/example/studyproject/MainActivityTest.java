package com.example.studyproject;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mainRule = new ActivityScenarioRule<>(MainActivity.class);
    public ActivityScenario<MainActivity> mainScenario;


    @Before
    public void setUp() throws Exception {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        mainScenario = mainRule.getScenario();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void ButtonClick() {
        Espresso.onView(withId(R.id.ComeInReg)).perform(click());
        User user = new User("User", "1234");
        Espresso.onView(withId(R.id.Login)).perform(typeText(user.username));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.Password)).perform(typeText(user.password));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.editTextText)).perform(typeText(user.username));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.editTextPassword)).perform(typeText(user.password));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.Loginbtn)).perform(click());
        Espresso.onView(withId(R.id.addPost)).perform(click());
        Espresso.onView(withId(R.id.PostTitle)).perform(typeText("Post"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.PostText)).perform(typeText("this is a new post"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.AddButton)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.PostsList)).atPosition(0).perform(click());
        Espresso.onView(withId(R.id.ChangeButton)).perform(click());
        Espresso.onView(withId(R.id.PostText1)).perform(clearText());
        Espresso.onView(withId(R.id.PostText1)).perform(typeText("this is the new post"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.ChangeButton)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.PostsList)).atPosition(0).perform(click());
        Espresso.onView(withId(R.id.PostText)).check(matches(withText("this is the new post")));
        Espresso.onView(withId(R.id.DeleteButton)).perform(click());
    }
}