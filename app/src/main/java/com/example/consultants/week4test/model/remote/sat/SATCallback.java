package com.example.consultants.week4test.model.remote.sat;

import com.example.consultants.week4test.model.NYResponse.SAT;

import java.util.List;

public interface SATCallback {
    void onSuccess(List<SAT> scores);

    void onFailure(String error);
}
