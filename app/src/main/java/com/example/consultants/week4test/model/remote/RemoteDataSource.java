package com.example.consultants.week4test.model.remote;

import com.example.consultants.week4test.NetworkHelper;
import com.example.consultants.week4test.model.NYResponse.NYResponse;
import com.example.consultants.week4test.model.NYResponse.School;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private Retrofit createInstance() {

        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_URL)
//                use for converting the response using Gson
                .addConverterFactory(GsonConverterFactory.create())
                //using rxjava adapter
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private  RemoteService getRemoteService() {
        return createInstance().create(RemoteService.class);
    }


    //using rxjava
    public Observable<List<School>> getSchoolObs() {
        return getRemoteService().getSchoolObs();
    }
}
