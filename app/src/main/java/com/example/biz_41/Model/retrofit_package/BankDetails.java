
package com.example.biz_41.Model.retrofit_package;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankDetails {

    @SerializedName("companyRegistrationNumber")
    @Expose
    private Integer companyRegistrationNumber;
    @SerializedName("bank")
    @Expose
    private String bank;
    @SerializedName("MFO")
    @Expose
    private String mFO;
    @SerializedName("INN")
    @Expose
    private String iNN;

    public Integer getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(Integer companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getMFO() {
        return mFO;
    }

    public void setMFO(String mFO) {
        this.mFO = mFO;
    }

    public String getINN() {
        return iNN;
    }

    public void setINN(String iNN) {
        this.iNN = iNN;
    }

}
