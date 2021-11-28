package com.example.mysubmission1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.animation.OvershootInterpolator;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private final ArrayList<Model> models = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_user);
        recyclerView.setHasFixedSize(true);

        models.addAll(getList());
        showRecylerList();

    }

    public ArrayList<Model> getList() {
        @SuppressLint("Recycle") TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_poto);
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataUsername = getResources().getStringArray(R.array.data_username);
        String[] dataLocation = getResources().getStringArray(R.array.data_location);
        int[] dataRepository = getResources().getIntArray(R.array.data_repository);
        String[] dataCompany = getResources().getStringArray(R.array.data_company);
        int[] dataFollowing = getResources().getIntArray(R.array.data_following);
        int[] dataFollower = getResources().getIntArray(R.array.data_follower);

        ArrayList<Model> listModel = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Model model = new Model();
            model.setAvatar(dataPhoto.getResourceId(i, -1));
            model.setName(dataName[i]);
            model.setUsername(dataUsername[i]);
            model.setCompany(dataCompany[i]);
            model.setLocation(dataLocation[i]);
            model.setRepository(dataRepository[i]);
            model.setFollowing(dataFollowing[i]);
            model.setFollower(dataFollower[i]);

            listModel.add(model);
        }
        return listModel;
    }

    private void showRecylerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(models);
        recyclerView.setAdapter(new ScaleInAnimationAdapter(listAdapter));

        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(new ListAdapter(models));
        alphaInAnimationAdapter.setDuration(1200);
        alphaInAnimationAdapter.setInterpolator(new OvershootInterpolator());
        alphaInAnimationAdapter.setFirstOnly(true);

    }
}