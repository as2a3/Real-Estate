package com.trioplus.realestate.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Ahmed on 11/22/2015.
 */
@DatabaseTable(tableName = "user")
public class Estate {

    @DatabaseField(id = true)
    private Integer id;

    @DatabaseField
    private String name;


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

}
