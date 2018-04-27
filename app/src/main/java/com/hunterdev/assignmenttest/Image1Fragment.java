package com.hunterdev.assignmenttest;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class Image1Fragment extends Fragment {
    @BindView(R.id.grid_image)
    GridView gridView;

    public Image1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image1, container, false);
        ButterKnife.bind(this,view);

        List<String> image_details = new ArrayList<>();
        image_details.add("https://pre00.deviantart.net/abfc/th/pre/i/2017/207/d/5/son_goku_base_l_by_jaredsongohan-dbhs3a6.png");
        image_details.add("https://vignette.wikia.nocookie.net/dragonball/images/1/12/Son_Goku_Character_Art.png/revision/latest?cb=20130625174106");
        image_details.add("https://orig00.deviantart.net/bfab/f/2011/209/5/0/songoku_ssj_by_say4-d41wtzl.png");
        image_details.add("https://tea-3.lozi.vn/v1/images/resized/usr-avatar-9646539-1511528455");
        image_details.add("https://tea-3.lozi.vn/v1/images/resized/usr-avatar-9646539-1511528455");
        gridView.setAdapter(new ImageAdapter(getActivity(), image_details));

        return view;
    }

}
