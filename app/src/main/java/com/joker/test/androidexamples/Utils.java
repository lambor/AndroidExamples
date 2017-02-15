package com.joker.test.androidexamples;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by lambor on 17-2-15.
 */

public class Utils {

    private static int screenWidth;
    private static int screenHeight;
    private static float density;

    private static synchronized void fetchScreenInfo(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displaymetrics);
        screenHeight = displaymetrics.heightPixels;
        screenWidth = displaymetrics.widthPixels;
        density = displaymetrics.density;
    }

    public static int screenHeight(Activity activity) {
        if(screenHeight == 0)
            fetchScreenInfo(activity);
        return screenHeight;
    }

    public static int screenWidth(Activity activity) {
        if(screenWidth == 0)
            fetchScreenInfo(activity);
        return screenWidth;
    }

    public static float screenDensity(Activity activity) {
        if(density == 0)
            fetchScreenInfo(activity);
        return density;
    }
}
