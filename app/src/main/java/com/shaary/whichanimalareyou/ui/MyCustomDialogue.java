package com.shaary.whichanimalareyou.ui;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.shaary.whichanimalareyou.R;

public class MyCustomDialogue extends DialogFragment {

    private static final String TAG = "MyCustomDialogue";

    public interface OnInputListener{
        void sendInput(String input);
    }

    public OnInputListener onInputListener;

    private EditText input;
    private TextView actionOk;
    private TextView actionCancel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogue_my_custom, container, false);

        actionCancel = view.findViewById(R.id.action_cancel);
        actionOk = view.findViewById(R.id.action_ok);
        input = view.findViewById(R.id.input);

        actionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        actionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anInput = input.getText().toString();
                onInputListener.sendInput(anInput);

                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onInputListener = (OnInputListener) getActivity();

        } catch (ClassCastException cce) {
            Log.e(TAG, "onAttach: ClassCastException" + cce.getMessage());
        }
    }
}
