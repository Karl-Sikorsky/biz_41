
package com.example.biz_41.Model.retrofit_package;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpenHours {

    @SerializedName("Mon-Fri")
    @Expose
    private String monFri;
    @SerializedName("Sat-Sun")
    @Expose
    private String satSun;

    public String getMonFri() {
        return monFri;
    }

    public void setMonFri(String monFri) {
        this.monFri = monFri;
    }

    public String getSatSun() {
        return satSun;
    }

    public void setSatSun(String satSun) {
        this.satSun = satSun;
    }

}
