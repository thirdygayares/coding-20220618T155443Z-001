package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Diaryview extends AppCompatActivity {
    TextView titlse, contexts;
    ImageView edit,delete,back_icon;
    TextView date_picker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diaryview);

        initview();




        String ID = getIntent().getStringExtra("ID");
        DatabaseHelper myDB = new DatabaseHelper(Diaryview.this);
        Cursor findData = myDB.findDiaries(ID);
        findData.moveToNext();
        date_picker.setText(findData.getString(3) + " " + findData.getString(4));
        titlse.setText(findData.getString(1));
        contexts.setText(findData.getString(2));




        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Diaryview.this, DiaryPage.class);
                startActivity(intent);
            }
        });


    }

    private void initview() {
        date_picker = findViewById(R.id.daterevealer);
        titlse = findViewById(R.id.titles);
        contexts = findViewById(R.id.notes);
        edit = findViewById(R.id.edit_icon);
        delete = findViewById(R.id.delete_icon);
        back_icon= findViewById(R.id.back_icon);

    }



}