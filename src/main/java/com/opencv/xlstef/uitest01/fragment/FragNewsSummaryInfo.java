package com.opencv.xlstef.uitest01.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opencv.xlstef.uitest01.R;

public class FragNewsSummaryInfo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.frag_news_summaryinfo,container,false);
        return view;
    }
}
