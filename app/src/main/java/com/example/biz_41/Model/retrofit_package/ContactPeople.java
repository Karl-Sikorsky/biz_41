
package com.example.biz_41.Model.retrofit_package;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactPeople {

    @SerializedName("manager")
    @Expose
    private String manager;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("accountant")
    @Expose
    private String accountant;

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDirector() {
        return director;
    }

    public ContactPeople() {
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAccountant() {
        return accountant;
    }

    public void setAccountant(String accountant) {
        this.accountant = accountant;
    }

}
