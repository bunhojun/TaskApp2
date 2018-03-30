package jp.techacademy.hojun.bun.taskapp;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by ponnp on 25/03/2018.
 */

public class TaskApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
