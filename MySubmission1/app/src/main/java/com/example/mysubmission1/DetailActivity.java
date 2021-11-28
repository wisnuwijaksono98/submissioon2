package com.example.mysubmission1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String GET_DATA = "get data";

    private TextView tvName, tvRepository, tvLocation, tvFollower, tvFollowing, tvCompany, tvUsername;
    private ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setById();
        getParcelable();
    }

    private void setById() {
        tvName = findViewById(R.id.tv_detail_name);
        tvUsername = findViewById(R.id.tv_detail_username);
        tvCompany = findViewById(R.id.tv_detail_company);
        tvFollowing = findViewById(R.id.tv_detail_following);
        tvFollower = findViewById(R.id.tv_detail_follower);
        tvRepository = findViewById(R.id.tv_detail_repository);
        tvLocation = findViewById(R.id.tv_detail_location);
        imgPhoto = findViewById(R.id.img_detail_photo);
    }

    @SuppressLint({"CheckResult", "SetTextI18n"})
    private void getParcelable() {

//        ArrayList<Model> model = getIntent().getParcelableArrayListExtra(GET_DATA);
        Model model = getIntent().getParcelableExtra(GET_DATA);

        if (model != null) {
            String name, username, company, location;
            int directory, follower, following, photo;

                name = model.getName();
                username = model.getUsername();
                company = model.getCompany();
                location = model.getLocation();
                directory = model.getRepository();
                follower = model.getFollower();
                following = model.getFollowing();
                photo = model.getAvatar();

                tvName.setText(" " + name);
                tvUsername.setText(" " + username);
                tvCompany.setText(" " + company);
                tvLocation.setText(" " + location);
                tvRepository.setText(" " + directory);
                tvFollower.setText(" " + follower);
                tvFollowing.setText(" " + following);

                Glide.with(this)
                        .load(photo)
                        .circleCrop()
                        .into(imgPhoto);

        }
    }
}