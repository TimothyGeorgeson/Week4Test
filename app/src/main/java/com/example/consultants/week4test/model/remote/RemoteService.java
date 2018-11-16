package com.example.consultants.week4test.model.remote;

import com.example.consultants.week4test.model.NYResponse.School;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RemoteService {

    @GET("97mf-9njv.json")
    Observable<List<School>> getSchoolObs();
}
