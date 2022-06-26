package com.example.tnr_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.tnr_listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.cupcake,R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb,R.drawable.icecream,
                R.drawable.jellybean,R.drawable.kitkat};

        String[] name = {"Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "HoneyComb", "IceCream", "Jelly Bean", "Kitkat"};

        ArrayList<AndroidFeatures> androidFeaturesArrayList = new ArrayList<>();

        for (int i = 0; i< imageId.length; i++){
            AndroidFeatures android = new AndroidFeatures(name[i],imageId[i]);
            androidFeaturesArrayList.add(android);


        }
        ListAdapter listAdapter = new ListAdapter(MainActivity.this,androidFeaturesArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    Intent i = new Intent(MainActivity.this, android_show.class);
                    i.putExtra("name", name[position]);
                    i.putExtra("imageid", imageId[position]);
                    startActivity(i);
            }
        });

    }
}