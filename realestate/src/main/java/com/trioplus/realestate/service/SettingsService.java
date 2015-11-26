package com.trioplus.realestate.service;

import android.content.Context;
import android.util.Log;

import com.trioplus.realestate.RealStateApplication;
import com.trioplus.realestate.model.Settings;
import com.trioplus.realestate.model.User;

import java.sql.SQLException;

/**
 * Created by Ahmed on 11/23/2015.
 */
public class SettingsService extends CommonService {

    public SettingsService(Context context) {
        super(context);
    }


    ///////////////////////////////////////////////////////////


    /**
     * user logged out
     */
    public Boolean setUserLoggedOut() {
        Settings settings = getSettings();
        User loggedInUser = settings.getLoggedInUser();
        if (loggedInUser != null) {
//            if (loggedInUser.getFacebookAccountId() != null && !loggedInUser.getFacebookAccountId().equals("")) {
//                FacebookSdk.sdkInitialize(TbkhaApp.getContext());
//                LoginManager.getInstance().logOut();
//            } else if (loggedInUser.getGooglePlusAccountId() != null && !loggedInUser.getGooglePlusAccountId().equals("")) {
//                //new LoginOldFragment().gPlusSignOut(TbkhaApp.getContext());
//            }
        }
        settings.setLoggedInUser(null);
        return updateSettings(settings);
    }


    /**
     *
     * @param settings
     * @return true if settings are updated successfully, false if not
     */
    public Boolean updateSettings(Settings settings) {
        Boolean result = false;
        try {
            if(settingsDao.update(settings) == 1) {
                result = true;
            }
        } catch (SQLException e) {
            Log.e(RealStateApplication.LOG_TAG, e.getMessage());
        }
        return result;
    }

    /**
     * set logged in user
     * @param loggedInUser
     */
    public Boolean setLoggedInUser(User loggedInUser) {

        Settings settings = getSettings();
        if (settings == null) {
            settings = new Settings();
            settings.setId(1);
        }
        settings.setLoggedInUser(loggedInUser);
        return updateSettings(settings);
    }

}
