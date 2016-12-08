package com.example.aoyler.pawarisaclinicapp;

import android.os.AsyncTask;

import java.io.IOException;

public abstract class  AddEvent_CalendarAsyncTask extends AsyncTask<Void, Void, Boolean> {

    final AddEvent_MainActivity activity;
    final com.google.api.services.calendar.Calendar client;


    AddEvent_CalendarAsyncTask(AddEvent_MainActivity activity) {
        this.activity = activity;
        client = activity.client;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        activity.numAsyncTasks++;
    }
    @Override
    protected final Boolean doInBackground(Void... ignored) {
        try {
            doInBackground();
            return true;
        }
        catch (IOException e) {
            Utils.logAndShow(activity, AddEvent_MainActivity.TAG, e);
        }
        return false;
    }
    abstract protected void doInBackground() throws IOException;
}
