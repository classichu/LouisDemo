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
 * Use the {@link CFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CFragment extends LazyLoadFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CFragment newInstance(String param1, String param2) {
        CFragment fragment = new CFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("zfq", "C onAttach: ");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.i("zfq", "C onCreate: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("zfq", "C onCreateView: ");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView= (TextView) view.findViewById(R.id.id_textview);
        Log.i("zfq", "C onViewCreated: ");

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("zfq", "C onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("zfq", "C onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("zfq", "C onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("zfq", "C onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("zfq", "C onStop: ");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("zfq", "C onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("zfq", "C onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("zfq", "C onDetach: ");
    }
    @Override
    public void onUserFirstVisible() {
        loadData();
        Log.i("zfq", "C onUserFirstVisible: ");
    }

    @Override
    public void onUserVisibleStateChange(boolean isVisible) {
        Log.i("zfq", "C onUserVisibleStateChange: "+isVisible);
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("zfq", "C setUserVisibleHint: "+isVisibleToUser);
    }
    private TextView textView;
    private CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            textView.setText("C"+millisUntilFinished);
        }

        @Override
        public void onFinish() {
            textView.setText("C数据加载完成！");
        }
    };

    public void loadData() {

        countDownTimer.start();
    }

}
