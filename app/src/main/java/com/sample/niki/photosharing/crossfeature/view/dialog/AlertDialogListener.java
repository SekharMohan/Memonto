package com.sample.niki.photosharing.crossfeature.view.dialog;

import android.content.DialogInterface;

/**
 * Created by ACMS - India
 */

public interface AlertDialogListener {
    void onPositiveClicked(DialogInterface dialog, int which);

    void onNegativeClicked(DialogInterface dialog, int which);
}
