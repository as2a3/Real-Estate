package com.trioplus.realestate.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.trioplus.realestate.RealStateApplication;
import com.trioplus.realestate.model.Estate;
import com.trioplus.realestate.model.Settings;
import com.trioplus.realestate.model.User;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ahmed on 11/22/2015.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "estate.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    private Dao<Settings, Integer> settingsDao = null;
    private Dao<User, Integer> userDao = null;
    private Dao<Estate, Integer> estateDao = null;


    // we do this so there is only one helper
    private static DatabaseHelper helper = null;
    private static final AtomicInteger usageCounter = new AtomicInteger(0);


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /**
     * Get the helper, possibly constructing it if necessary. For each call to this method, there should be 1 and only 1
     * call to {@link #close()}.
     */
    public static synchronized DatabaseHelper getHelper(Context context) {
        if (helper == null) {
            helper = new DatabaseHelper(context);
        }
        usageCounter.incrementAndGet();
        return helper;
    }


    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(RealStateApplication.LOG_TAG, "onCreate");
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Settings.class);
            TableUtils.createTable(connectionSource, Estate.class);

            initData();
        } catch (SQLException e) {
            Log.e(RealStateApplication.LOG_TAG, "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        Log.i(RealStateApplication.LOG_TAG, "onUpgrade");
    }


    private void initData(){
        Log.d(RealStateApplication.LOG_TAG, "data initiating");

        Settings settings = new Settings();
        settings.setId(1);
        try {
            settingsDao.create(settings);
        } catch (SQLException e) {
            Log.e(RealStateApplication.LOG_TAG, "Data init2 ERROR");
        }
    }


    public Dao<Settings, Integer> getSettingsDao() {
        if (settingsDao == null) {
            try {
                settingsDao = getDao(Settings.class);
            } catch (SQLException e) {
            }
        }
        return settingsDao;
    }

    public Dao<User, Integer> getUserDao() {
        if (userDao == null) {
            try {
                userDao = getDao(User.class);
            } catch (SQLException e) {
            }
        }
        return userDao;
    }

    public Dao<Estate, Integer> getEstateDao() {
        if (estateDao == null) {
            try {
                estateDao = getDao(Estate.class);
            } catch (SQLException e) {
            }
        }
        return estateDao;
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();

        settingsDao = null;
        userDao = null;
        estateDao = null;
    }
}
