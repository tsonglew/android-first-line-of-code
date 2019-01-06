package com.example.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

    private static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity ac) {
        activities.add(ac);
    }

    public static void removeActivity(Activity ac) {
        activities.remove(ac);
    }

    public static void finishAll() {
        for (Activity a: activities) {
            if (!a.isFinishing()) {
                a.finish();
            }
        }
    }
}
