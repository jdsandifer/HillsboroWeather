package com.jdsandifer.hillsboroweather;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by j.d. sandifer on 4/2/2015.
 */
public class AlertDialogFragment extends DialogFragment {

    String mMessage;

    /**
     * Create a new instance of MyDialogFragment, providing "message"
     * as an argument.
     */
    public static AlertDialogFragment newInstance(String message) {
        AlertDialogFragment fragment = new AlertDialogFragment();

        // Supply message input through bundle.
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mMessage = getArguments().getString("message");

        Context context = getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.error_title))
                .setMessage(mMessage)
                .setPositiveButton(context.getString(R.string.error_ok_button_text), null);

        return builder.create();
    }

}
