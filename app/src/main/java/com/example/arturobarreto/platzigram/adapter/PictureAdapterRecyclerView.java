package com.example.arturobarreto.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arturobarreto.platzigram.PictureDetailActivity;
import com.example.arturobarreto.platzigram.R;
import com.example.arturobarreto.platzigram.model.Picture;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by arturobarreto on 19/02/18.
 */

public class PictureAdapterRecyclerView extends  RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{


    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;


    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }



    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, final int position) {

        Picture picture = pictures.get(position);
        holder.userNameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLikeNumber());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        // estamos teniendoacceso a los view de la lista todo en este metodo

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);
                /// transciones perro
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, activity.getString(R.string.transitionname_picture)).toBundle());
                }
                else {
                    // esta es la transicion que estan conrriendo en versiones menores al API 21 que es lollipop
                    activity.startActivity(intent);
                }





            }
        });

    }

    @Override
    public int getItemCount() {
        return pictures.size(); // cuantas veces recorre el array
    }

    public  class  PictureViewHolder extends RecyclerView.ViewHolder{


        // crear todos los views que componen al cardView
        private ImageView pictureCard;
        private TextView userNameCard;
        private TextView timeCard;
        private  TextView likeNumberCard;



        public PictureViewHolder(View itemView) {
            super(itemView);

            pictureCard = (ImageView) itemView.findViewById(R.id.pictureCardImage);
            userNameCard = (TextView) itemView.findViewById(R.id.userNameCard);
            timeCard = (TextView) itemView.findViewById(R.id.timeCard);
            likeNumberCard = (TextView)itemView.findViewById(R.id.likeNumberCard);
        }
    }
}
