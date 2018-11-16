package com.example.consultants.week4test.model.NYResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NYResponse {

    @SerializedName("schools")
    @Expose
    private List<School> schools = null;

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

}
