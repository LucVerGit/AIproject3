package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.OnClick;

public class NeighbourPage extends AppCompatActivity {

    @BindView(R.id.button_back)
    ImageButton mButtonBack;

    @BindView(R.id.addfavorite)
    FloatingActionButton mImageButtonFav;

    @BindView(R.id.image_avatar)
    ImageView mImageViewAvatar;

    @BindView(R.id.nameProfil)
    TextView mTextViewNameProfil;

    @BindView(R.id.activity_name_text)
    TextView mTextViewNameText;

    @BindView(R.id.activity_phone_text)
    TextView mTextViewPhoneText;

    @BindView(R.id.activity_mail_text)
    TextView mTextViewMailText;

    @BindView(R.id.activity_address_text)
    TextView mTextViewAddress;

    @BindView(R.id.activity_aboutMe_text)
    TextView mTextViewAbouteMe;

    private NeighbourApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_page);
        mApiService = DI.getNeighbourApiService();
        displayDetail();
        actionOnFavoriteButton();
        actionOnButtonback();

    }
      // afficher les infos
    private void displayDetail() {
        if (getIntent().hasExtra("Neighbour")) {
            Neighbour neighbour = getIntent().getExtras().getParcelable("Neighbour");

            Glide.with(this)
                    .load(neighbour.getAvatarUrl())
                    .into(mImageViewAvatar);
            mTextViewNameText.setText(neighbour.getName());
            mTextViewNameProfil.setText(neighbour.getName());
            mTextViewAddress.setText(neighbour.getAddress());
            mTextViewAbouteMe.setText(neighbour.getAboutMe());
            mTextViewMailText.setText("facebook.fr/" + neighbour.getName());
            mTextViewPhoneText.setText(neighbour.getPhoneNumber());
        }
    }
    ///activation du bouton favorite pour ajouter dans la seconde liste
    private void actionOnFavoriteButton() {
        if (getIntent().hasExtra("Neighbour")) {
            Neighbour neighbour = getIntent().getParcelableExtra("Neighbour");

            if (mApiService.getFavoriteNeighbour().contains(neighbour)) {
                mImageButtonFav.setImageResource(R.drawable.ic_baseline_favorite_24);
            }

            mImageButtonFav.setOnClickListener(v -> {
                if (!mApiService.getFavoriteNeighbour().contains(neighbour)) {
                    mApiService.addFavoriteNeighbour(neighbour);

                    mImageButtonFav.setImageResource(R.drawable.ic_star_white_24dp);
                    Toast.makeText(this, "favorite is add in your personnal list", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, " already favorite ", Toast.LENGTH_SHORT).show();
                }

            });

        }
    }
        /// retour page d'avant
    private void actionOnButtonback() { mButtonBack.setOnClickListener(v -> { finish(); }); }


}