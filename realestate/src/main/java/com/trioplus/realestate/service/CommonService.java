package com.trioplus.realestate.service;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.j256.ormlite.dao.Dao;
import com.trioplus.realestate.RealStateApplication;
import com.trioplus.realestate.database.DatabaseHelper;
import com.trioplus.realestate.model.Estate;
import com.trioplus.realestate.model.Settings;
import com.trioplus.realestate.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ahmed on 11/22/2015.
 */
public class CommonService {

    public Dao<User, Integer> userDao;
    public Dao<Settings, Integer> settingsDao;
    public Dao<Estate, Integer> estateDao;

    public CommonService(Context context) {
        userDao = DatabaseHelper.getHelper(context).getUserDao();
        settingsDao = DatabaseHelper.getHelper(context).getSettingsDao();
        estateDao = DatabaseHelper.getHelper(context).getEstateDao();
    }


    /**
     * save user to database and create new record for profileImage
     * @param user
     * @return true if user is added successfully, false if not
     */
    public Boolean saveUser(User user) {
        Boolean result = false;

        try {
            Dao.CreateOrUpdateStatus status = userDao.createOrUpdate(user);
            if (status.isCreated() || status.isUpdated()) {
                result = true;
            }
        } catch (SQLException e) {
            Log.e(RealStateApplication.LOG_TAG, e.getMessage());
        }
        return result;
    }

    /**
     * display image with Glide into imageView
     * @param imageUrl
     * @param imageView
     */
    public void displayImage(String imageUrl, ImageView imageView) {
        Glide.with(RealStateApplication.getContext()).load(imageUrl).thumbnail(0.01f)
                .crossFade().into(imageView);
    }

    /**
     *
     * @return Settings
     */
    public Settings getSettings() {
        Settings settings = null;
        List<Settings> list;
        try {
            list = settingsDao.queryForAll();
            if (list.size() == 1) {
                settings = list.get(0);
            }
        } catch (SQLException e) {
            Log.e(RealStateApplication.LOG_TAG, e.getMessage());
        }
        return settings;
    }

    /**
     * true if user is logged in, false if not
     * @return
     */
    public Boolean checkLoggedInUser() {
        Settings settings = getSettings();
        if (settings == null) {
            return false;
        }
        return ((settings.getLoggedInUser() == null) ? false : true);
    }

}
