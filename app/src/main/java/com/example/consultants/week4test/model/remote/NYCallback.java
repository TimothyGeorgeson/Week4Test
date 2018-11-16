package com.example.consultants.week4test.model.remote;

import com.example.consultants.week4test.model.NYResponse.School;

import java.util.List;

public interface NYCallback {
    void onSuccess(List<School> schools);

    void onFailure(String error);
}
