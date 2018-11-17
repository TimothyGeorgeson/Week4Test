package com.example.consultants.week4test.model.remote.school;

import com.example.consultants.week4test.model.NYResponse.School;

import java.util.List;

public interface SchoolCallback {
    void onSuccess(List<School> schools);

    void onFailure(String error);
}
