package cn.studyjams.s2.sj0224.beautyalarm;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation rest, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under rest.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("cn.studyjams.s2.sj0224.beautyalarm", appContext.getPackageName());
    }
}
