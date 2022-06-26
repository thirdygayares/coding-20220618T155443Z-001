package com.example.tnr_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tnr_listview.databinding.ActivityAndroidShowBinding;
import com.example.tnr_listview.databinding.ActivityMainBinding;

public class android_show extends AppCompatActivity {

    ActivityAndroidShowBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAndroidShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){
            String name = intent.getStringExtra("name");
            int imageid = intent.getIntExtra("imageid", R.drawable.kitkat);

            binding.image2.setImageResource(imageid);
            binding.name2.setText(name);
        }



    }
}