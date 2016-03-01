package com.example.ram1991.creativewebmedianewsfeed.ui.fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.example.ram1991.creativewebmedianewsfeed.R;

public class FragmentInternetInfo extends DialogFragment {
    public static String TAG = "FragmentInternetInfo";
    private Button buttonOK;
    OnInternetInfoListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        return inflater.inflate(R.layout.dialog_internet_info, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnInternetInfoListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnInternetInfoListener");
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        buttonOK = (Button) view.findViewById(R.id.button_ok_internet_connection);
        setListeners(buttonOK);
    }

    private void setListeners(Button button) {
        if (button.equals(buttonOK)) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.resetInternetConnected();
                    dismiss();
                }
            });
        } else {
            throw new ClassCastException();
        }
    }

    public interface OnInternetInfoListener {
        void resetInternetConnected();
    }


}
