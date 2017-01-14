package com.pamula.kasir.helper;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by DEKSTOP on 12/01/2017.
 */
public class Message {

    /**
     * Create Toast Information
     */
    public static void showToast(Context context, String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
