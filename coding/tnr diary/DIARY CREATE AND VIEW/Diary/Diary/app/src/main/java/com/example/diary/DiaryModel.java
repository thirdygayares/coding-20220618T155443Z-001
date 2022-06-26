package com.example.diary;

public class DiaryModel {
    String id;
    int ids;
    String Title;
    String Context;
    String DateMonth;
    String Dateday;
    String WholeDay;



    public DiaryModel(int ids, String title, String context, String dateMonth, String dateday, String wholeDay) {
        this.ids = ids;
        Title = title;
        Context = context;
        DateMonth = dateMonth;
        Dateday = dateday;
        WholeDay = wholeDay;
    }

    public DiaryModel(String id, String title, String context, String datemonth, String dateday) {
        this.id = id;
        this.Title = title;
        this.Context = context;
        this.DateMonth = datemonth;
        this.Dateday = dateday;

    }
    public String getWholeDay() {
        return WholeDay;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getTitle() {
        return Title;
    }


    public String getContext() {
        return Context;
    }


    public String getDateMonth() {
        return DateMonth;
    }


    public String getDateday() {
        return Dateday;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setContext(String context) {
        Context = context;
    }

    public void setDateMonth(String dateMonth) {
        DateMonth = dateMonth;
    }

    public void setDateday(String dateday) {
        Dateday = dateday;
    }

    public void setWholeDay(String wholeDay) {
        WholeDay = wholeDay;
    }
}
