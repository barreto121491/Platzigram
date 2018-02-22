 package com.example.arturobarreto.platzigram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arturobarreto.platzigram.R;
import com.example.arturobarreto.platzigram.adapter.PictureAdapterRecyclerView;
import com.example.arturobarreto.platzigram.model.Picture;

import java.util.ArrayList;

 /**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("", true, view);
        RecyclerView picturesRecicler = (RecyclerView)view.findViewById(R.id.pictureProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecicler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());

        picturesRecicler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public void showToolbar(String title, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
     public ArrayList<Picture> buildPictures(){

         ArrayList<Picture> pictures = new ArrayList<>();
         pictures.add(new Picture("data:image/jpeg;base64,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", "Alan Jesus", "4 dias", "23"));
         pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLGCuUiFTncdkU3lDE_9hm7gltJB5XGHKz_5NNHKidMU_TRxK5", "Ofelia Villafan", "2 dias", "43"));
         pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEADiibNdvBJpdjd9Y0_JzWu68IkzNXwOfcOxiy_BbnYNV2hwC", "Arturo Barreto", "4 dias", "25"));
         pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXQkZ03NahchNqu9jVeQaNJixaciX3BQSXRFcQZ_mA2m87U6WVsg", "Salvador Barreto", "2 dias", "33"));
         pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQB-0HhoHoXsrA_73kG9MKXtoF-PbU3o8N0gtTLyjz5yoAhRW2S", "Maria Clara", "12 dias", "34"));
         return  pictures;
     }
}
