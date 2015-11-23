package com.trioplus.realestate.service;

import android.content.Context;
import android.util.Log;

import com.trioplus.realestate.RealStateApplication;
import com.trioplus.realestate.model.User;

import java.sql.SQLException;

/**
 * Created by Ahmed on 11/22/2015.
 */
public class UserService extends CommonService {

    public UserService(Context context) {
        super(context);
    }


    /**
     * get user with id
     * @param userId
     * @return
     */
    public User getUser(Integer userId) {
        User user = null;

        try {
            user = userDao.queryForId(userId);
        } catch (SQLException e) {
            Log.e(RealStateApplication.LOG_TAG, e.getMessage());
        }
        return user;
    }
}
