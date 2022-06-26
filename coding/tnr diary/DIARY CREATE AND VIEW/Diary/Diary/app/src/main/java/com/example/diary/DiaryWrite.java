package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DiaryWrite extends AppCompatActivity {

    String dateTimestamp, dateday, datemonth;
    CardView datepicker;
    ImageView back_icon;
    Button publish;
    TextView daterevealer;
    EditText notes,title;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_write);
        initxml();
        String pattern = "MMMM dd yyyy";
        Date date = new Date();
        SimpleDateFormat x = new SimpleDateFormat(pattern);
        daterevealer.setText(x.format(date));

        pattern = "yyyy M dd";
        x = new SimpleDateFormat(pattern);
        dateTimestamp = x.format(date);

        pattern = "MMMM";
         x = new SimpleDateFormat(pattern);
        datemonth = x.format(date);

        pattern = "dd";
        x = new SimpleDateFormat(pattern);
        dateday = x.format(date);


        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(DiaryWrite.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {


                                String month_conversion = "";

                                if (monthOfYear + 1 == 1) {
                                    month_conversion = "January";

                                } else if (monthOfYear + 1 == 2){
                                    month_conversion = "February";
                                } else if (monthOfYear + 1 == 3){
                                    month_conversion = "March";
                                } else if (monthOfYear + 1 == 4){
                                    month_conversion = "April";
                                } else if (monthOfYear + 1 == 5){
                                    month_conversion = "May";
                                } else if (monthOfYear + 1 == 6){
                                    month_conversion = "June";
                                } else if (monthOfYear + 1 == 7){
                                    month_conversion = "July";
                                } else if (monthOfYear + 1 == 8){
                                    month_conversion = "August";
                                } else if (monthOfYear + 1 == 9){
                                    month_conversion = "September";
                                } else if (monthOfYear + 1 == 10){
                                    month_conversion = "October";
                                } else if (monthOfYear + 1 == 11){
                                    month_conversion = "November";
                                } else if (monthOfYear + 1 == 12){
                                    month_conversion = "December";
                                }

                                datemonth = month_conversion;

                                dateday = String.valueOf(dayOfMonth);
                                 dateTimestamp =  year + " " + (monthOfYear + 1) + " " + dayOfMonth ;

                                daterevealer.setText(datemonth + " " + dayOfMonth + " "  + year );

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiaryWrite.this, DiaryPage.class);
                startActivity(intent);
            }
        });


        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editTextValue= notes.getText().toString();

                if(!notes.getText().toString().isEmpty()  && !title.getText().toString().isEmpty() ){



                DiaryModel diaryModel;
                try{
                    diaryModel = new DiaryModel(-1, title.getText().toString(), notes.getText().toString(),datemonth,dateday ,dateTimestamp );

                    title.setText("");
                    notes.setText("");
                    Log.v("TAG","add successfulyy");

                }catch (Exception e){
                    Toast.makeText(DiaryWrite.this, "Error Uploading Data", Toast.LENGTH_SHORT).show();
                    diaryModel = new DiaryModel(-1, "error", "error", "error", "error","error");
                    Log.v("TAG","not successfulyy");
                }

                // public DiaryModel(String id, String title, String context, String dateMonth, String dateday, String wholeDay)

                DatabaseHelper databaseHelper = new DatabaseHelper(DiaryWrite.this);
                boolean success = databaseHelper.addOne(diaryModel);
                Snackbar.make(view,  " Status " + success, Snackbar.LENGTH_LONG).setAction("Action", null).show();

                Intent intent = new Intent(DiaryWrite.this, DiaryPage.class);
                startActivity(intent);
            }else{

                    Snackbar.make(view, "Please Write Title and Your Notes", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                }
            }
        });

    }

    private void initxml() {
        datepicker = findViewById(R.id.date_picker);
        back_icon = findViewById(R.id.back_icon);
        publish = findViewById(R.id.publish);
        notes = findViewById(R.id.notes);
        title = findViewById(R.id.titles);
        daterevealer = findViewById(R.id.daterevealer);

    }
}