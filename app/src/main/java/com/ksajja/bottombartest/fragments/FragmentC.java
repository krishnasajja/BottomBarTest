package com.ksajja.bottombartest.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ksajja.bottombartest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentC extends Fragment {

    public static final String TAG = "C";

    private TextView mTextView;


    public FragmentC() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = ((TextView) view.findViewById(R.id.textView));
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("Fragment C updated");
            }
        });

    }

    public static String getTAG() {
        return TAG;
    }

}
