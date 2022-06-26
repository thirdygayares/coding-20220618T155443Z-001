package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class DiaryPage extends AppCompatActivity implements DiaryInterface {
//    RecyclerView recyclerView;
    Button write;
    ArrayList<DiaryModel> diaryModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diarypage);

        Log.v("tag", "hello world");
        retrievingData();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        write = findViewById(R.id.write);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiaryPage.this, DiaryWrite.class);
                startActivity(intent);
            }
        });

        Log.v("tag", "hello world");

        DiaryAdapter adapter = new DiaryAdapter(this, diaryModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.v("tag", String.valueOf(diaryModels.size()));



    }




    private void retrievingData (){
//        String[] Title = {"Ang Pagibig kong nagluksa", "Bakit mo ba ako sinasaktan", "Ayaw ko na", "Mahal Pa rin kita"};
//        String[] Context = {"hays ayaw ko na talaga, hays ayaw ko na talaga, hays ayaw ko na talaga,hays ayaw ko na talaga", "sana wag mo na ko saktan bukas" , "malabo maging tayo", "Bakit ? ready naman ako masaktan ah"};
//        String[] Month = {"June", "June", "June", "June"};
//        String[] Day = {"6", "5", "4", "12"};
        ArrayList<String> id = new ArrayList<>();
        ArrayList<String> Title = new ArrayList<>();
        ArrayList<String> Context = new ArrayList<>();
        ArrayList<String> Month = new ArrayList<>();
        ArrayList<String> Day = new ArrayList<>();



        DatabaseHelper myDB = new DatabaseHelper(DiaryPage.this);

        Cursor data = myDB.getDiaryNotes();

        if(data.getCount() == 0 ){
            //dito ilagay ang graphics pag wala pang history
            Intent intent = new Intent(DiaryPage.this, MainActivity.class);
            startActivity(intent);
        }else {
            while (data.moveToNext()) {
                id.add(data.getString(0));
                Title.add(data.getString(1));
                Context.add(data.getString(2));
                Month.add(data.getString(3));
                Day.add(data.getString(4));
            }
        }


        for(int i=0; i<Title.size(); i++){
            diaryModels.add(new DiaryModel(id.get(i), Title.get(i)
                    , Context.get(i),  Month.get(i), Day.get(i)
                    ));
        }
    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(DiaryPage.this, Diaryview.class);
        intent.putExtra("ID", diaryModels.get(position).getId());

        Log.v("tag", String.valueOf(diaryModels.get(position).getId()) );
        Log.v("tag", "mabuhay" );
        startActivity(intent);
    }

}


