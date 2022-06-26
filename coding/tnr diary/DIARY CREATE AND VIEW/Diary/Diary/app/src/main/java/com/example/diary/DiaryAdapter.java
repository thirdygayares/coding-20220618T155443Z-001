package com.example.diary;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.MyViewHolder> {


    private final DiaryInterface diaryInterfaces;

    Context context;
    ArrayList<DiaryModel> diarymodels;

    public DiaryAdapter(Context context, ArrayList<DiaryModel> diarymodels, DiaryInterface diaryInterfaces){
        this.context = context;
        this.diarymodels = diarymodels;
        this.diaryInterfaces = diaryInterfaces;

    }

    @NonNull
    @Override
    public DiaryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType  ) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.diarylist, parent, false);

        return new DiaryAdapter.MyViewHolder(view,diaryInterfaces);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryAdapter.MyViewHolder holder, int position) {
        holder.diaryTitle.setText(diarymodels.get(position).getTitle());
        holder.content.setText(diarymodels.get(position).getContext());
        holder.month.setText(diarymodels.get(position).getDateMonth());
        holder.day.setText(diarymodels.get(position).getDateday());
    }

    @Override
    public int getItemCount() {
        return diarymodels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView diaryTitle, content, month, day;

        public MyViewHolder(@NonNull View itemView, DiaryInterface diaryInterfaces) {
            super(itemView);
            month = itemView.findViewById(R.id.month);
            diaryTitle = itemView.findViewById(R.id.diaryTitle);
            content = itemView.findViewById(R.id.content);
            day = itemView.findViewById(R.id.day);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(diaryInterfaces != null ){
                        int pos = getAdapterPosition();
                        if(pos!= RecyclerView.NO_POSITION){
                            diaryInterfaces.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }

}