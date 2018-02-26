package com.sample.niki.photosharing.crossfeature.view.loader;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.acms.nissanconnectbox.R;
import com.acms.nissanconnectbox.cross.MemontoLog;

/**
 * Created by Renault Nissan Technology & Business Center India Pvt Ltd
 * Copyright (c) 2016 Renault Nissan Technology & Business Center India Pvt Ltd
 */
public class Loader {

    private static Dialog progressDialog = null;

    public static void showProgressBar(Context context) {
        try {

            if (progressDialog == null) {
                progressDialog = new Dialog(context);
            }

            if (!progressDialog.isShowing()) {
                progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                progressDialog.setContentView(R.layout.layout_progress_bar);

                DisplayMetrics metrics = context.getResources().getDisplayMetrics();
                int width = metrics.widthPixels;
                int height = metrics.heightPixels;

                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                progressDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

                progressDialog.getWindow().setLayout(width, height);
                progressDialog.getWindow().setGravity(Gravity.CENTER);

                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);

                progressDialog.show();
            }
        } catch (
                Exception exception)

        {
            MemontoLog.e(exception.toString());
        }

    }

    /**
     * Used for hiding the progress bar
     */
    public static void dismissProgressBar() {
        try {
            if (progressDialog != null) {
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception exception) {
            MemontoLog.e(exception.toString());
        }
    }

    public static boolean isProgressBarShowing() {
        return progressDialog != null && progressDialog.isShowing();
    }
}