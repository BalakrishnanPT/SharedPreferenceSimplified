package me.balakrishnan.sharedPreferenceHelper;

import android.content.Context;
import android.util.Log;

public class PrefTest {
    Context context;
    private static final String TAG = "PrefTest";

    public PrefTest(Context context) {
        this.context = context;
        print();
    }

    public void print() {
        PreferenceHelper preferenceHelper = new PreferenceHelper(context, context.getApplicationInfo().packageName);
        Log.d(TAG, "print: user ID " + preferenceHelper.getUserID());
    }

}
