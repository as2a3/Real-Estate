package com.trioplus.realestate.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Ahmed on 11/22/2015.
 */
@DatabaseTable(tableName = "user")
public class User {

    @DatabaseField(id = true)
    private Integer id;

    @DatabaseField
    private String name;

    @DatabaseField(columnName = "email")
    private String email;

    @DatabaseField(columnName = "avatar")
    private String avatar;

    //////////////////////////////////Setter and getter/////////////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
