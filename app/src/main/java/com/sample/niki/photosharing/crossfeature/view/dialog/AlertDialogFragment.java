package com.sample.niki.photosharing.crossfeature.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;



import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sekhar Madhiyazhagan
 */

public class AlertDialogFragment extends DialogFragment {
    /***********************************************************
     * Tags
     **********************************************************/
    private static final String TAG = "AlertDialogFragment";
    /***********************************************************
     *  Constants / Keys
     **********************************************************/
    /**
     * Key for the bundle new instance
     */
    final private static String TITLE = "title";
    final private static String MESSAGE = "message";
    final private static String MESSAGE_STRING = "messagestring";

    /***
     * Key for retrieving the AlertDialog
     */
    final public static String TAG_DEFAULT = "default";
    final public static String TAG_INFO = "info";
    /**
     * The TYPE_DEFAULT displays the buttons Ok and Cancel
     * call setType
     */
    final public static int TYPE_DEFAULT = 0;
    /**
     * The TYPE_DEFAULT displays the buttons Ok and Cancel
     * call setType
     */
    final public static int TYPE_INFO = 1;
    /***********************************************************
     *  Attributes
     **********************************************************/
    /**
     * Should be one of the type
     * TYPE_DEFAULT
     * or
     * TYPE_INFO
     */
    private int dialogType = TYPE_DEFAULT;//Default = 0 (action alert = OK,Cancel) , 1= (confirm alert = OK)
    /**
     * The OkCancel callbacks
     */
    public AlertDialogListener listener = null;
    /**
     * The dialog Title
     */
    private String dialogTitle = null;
    /**
     * The dialog message
     */
    private String dialogMessage = null;

    /**
     * The dialog positive button
     */

    private String positiveButton = null;
    /**
     * The dialog negative button
     */

    private String negativeButton = null;

    @BindView(R.id.dialogToolbarTitle)
    TextView customTitle;

    /***********************************************************
     *  NewInstance Pattern
     *  This pattern is used when the system create your fragment and you don't have the hands on it
     *  Should not be used in our context
     *  More for fragments in ViewPager
     **********************************************************/

    /**
     * New Instance pattern of the fragment
     *
     * @param titleIdRes   Title to display
     * @param messageIdRes Message to display
     * @return The fragment
     */
    public static AlertDialogFragment newInstance(int titleIdRes, int messageIdRes) {
        AlertDialogFragment frag = new AlertDialogFragment();
        Bundle args = new Bundle();
        args.putInt(TITLE, titleIdRes);
        args.putInt(MESSAGE, messageIdRes);
        frag.setArguments(args);
        return frag;
    }

    /**
     * New Instance pattern of the fragment
     * Beacause sometimes you have parameters in your message and just ce resource's id is not enough
     *
     * @param titleIdRes Title to display
     * @param message    Message to display
     * @return The fragment
     */
    public static AlertDialogFragment newInstance(int titleIdRes, String message) {
        AlertDialogFragment frag = new AlertDialogFragment();
        Bundle args = new Bundle();
        args.putInt(TITLE, titleIdRes);
        args.putString(MESSAGE_STRING, message);
        frag.setArguments(args);
        return frag;
    }

    /***********************************************************
     *  Managing LifeCycle
     **********************************************************/
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        MemontoLog.e(TAG, "onCreateDialog called");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.theme_alert_dialog);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.dialog_titlebar, null);
        ButterKnife.bind(this, view);


        //Title,Message initialization
        if (dialogMessage == null) {
            if (getArguments() != null && getArguments().containsKey(TITLE)) {
                dialogTitle = getResources().getString(getArguments().getInt(TITLE));
            } else {
                dialogTitle = getResources().getString(R.string.alert_dialog_title_empty);
            }
        }
        if (dialogTitle == null) {
            if (getArguments() != null && getArguments().containsKey(MESSAGE)) {
                dialogMessage = getResources().getString(getArguments().getInt(MESSAGE));
            } else if (getArguments() != null && getArguments().containsKey(MESSAGE_STRING)) {
                dialogMessage = getArguments().getString(MESSAGE_STRING);
            } else {
                dialogMessage = getResources().getString(R.string.alert_dialog_message_empty);
            }
        }
        //Builder pattern:
        customTitle.setText(dialogTitle);
        builder.setCustomTitle(view)
                .setMessage(dialogMessage)
                .setPositiveButton(positiveButton,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (listener != null) {
                                    listener.onPositiveClicked(dialog, which);
                                }
                            }
                        }
                );
        if (dialogType != TYPE_INFO) {
            builder.setNegativeButton(negativeButton,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            if (listener != null) {
                                listener.onNegativeClicked(dialog, which);
                            }
                        }
                    }
            );
        }


        return builder.create();
    }

    @Override
    public void onResume() {
        super.onResume();
        getDialog().setTitle(dialogTitle);
        ((AlertDialog) getDialog()).setMessage(dialogMessage);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //No data to save
    }


    /***********************************************************
     *  Setters
     **********************************************************/
    /**
     * Set the type of the dialog according to the constant
     * TYPE_DEFAULT or TYPE_INFO
     *
     * @param dialogType
     */
    public void setDialogType(int dialogType) {
        MemontoLog.e(TAG, "setDialogType called");
        this.dialogType = dialogType;
    }

    public void setDialogData(int dialogTitleRes, int dialogMessageRes) {
        MemontoLog.e(TAG, "setDialogData called");
        this.dialogMessage = BaseApplication.res().getString(dialogMessageRes);
        this.dialogTitle = BaseApplication.res().getString(dialogTitleRes);
        this.positiveButton = BaseApplication.res().getString(R.string.ok);
        this.negativeButton = BaseApplication.res().getString(R.string.cancel);
    }

    public void setDialogData(int dialogTitleRes, int dialogMessageRes, int positiveRes, int negativeRes) {
        MemontoLog.e(TAG, "setDialogData called");
        this.dialogMessage = BaseApplication.res().getString(dialogMessageRes);
        this.dialogTitle = BaseApplication.res().getString(dialogTitleRes);
        this.positiveButton = BaseApplication.res().getString(positiveRes);
        this.negativeButton = BaseApplication.res().getString(negativeRes);
    }

    public void setListener(AlertDialogListener listener) {
        MemontoLog.e(TAG, "setListener called");
        this.listener = listener;
    }
}

