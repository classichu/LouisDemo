package com.classichu.louisdemo.Fragment.lazyload.frags;


import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.classichu.louisdemo.Fragment.lazyload.LazyLoadFragment;
import com.classichu.louisdemo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DFragment extends LazyLoadFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public DFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DFragment newInstance(String param1, String param2) {
        DFragment fragment = new DFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("zfq", "D onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.i("zfq", "D onCreate: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("zfq", "D onCreateView: ");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_d, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView= (TextView) view.findViewById(R.id.id_textview);
        Log.i("zfq", "D onViewCreated: ");

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("zfq", "D onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("zfq", "D onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("zfq", "D onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("zfq", "D onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("zfq", "D onStop: ");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("zfq", "D onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("zfq", "D onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("zfq", "D onDetach: ");
    }
    @Override
    public void onUserFirstVisible() {
        loadData();
        Log.i("zfq", "D onUserFirstVisible: ");
    }

    @Override
    public void onUserVisibleStateChange(boolean isVisible) {
        Log.i("zfq", "D onUserVisibleStateChange: "+isVisible);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("zfq", "D setUserVisibleHint: "+isVisibleToUser);
    }

    private TextView textView;
    private CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            textView.setText("D"+millisUntilFinished);
        }

        @Override
        public void onFinish() {
            textView.setText("D数据加载完成！");
        }
    };

    public void loadData() {

        countDownTimer.start();
    }

}
