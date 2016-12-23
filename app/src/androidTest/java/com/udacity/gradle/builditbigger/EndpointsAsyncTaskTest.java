package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Eman on 12/21/2016.
 */

public class EndpointsAsyncTaskTest extends AndroidTestCase implements EndpointsAsyncTask.AsyncFinish{

   @Test
    public void testJoke(){
        try {
            EndpointsAsyncTask jokeTask = new EndpointsAsyncTask(this);
            jokeTask.execute();
            String joke = jokeTask.get(30, TimeUnit.SECONDS);
            Assert.assertNotNull(joke);
        } catch (Exception e) {
            fail("Timed out");
        }
    }

    @Override
    public void processFinish(String output) {

    }
}
