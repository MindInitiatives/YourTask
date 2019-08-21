package com.mindinitiatives.yourtask.Model;

public class Data {

    private String title;
    private String note;
    private String data;
    private String id;

    public Data() {
    }

    public Data(String title, String note, String data, String id) {
        this.title = title;
        this.note = note;
        this.data = data;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
