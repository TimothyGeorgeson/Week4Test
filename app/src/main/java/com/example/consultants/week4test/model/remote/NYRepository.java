package com.example.consultants.week4test.model.remote;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NYRepository {

    RemoteDataSource remoteDataSource;

    public NYRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void getSchools(final NYCallback callback) {

        remoteDataSource.getSchoolObs()
//                    make the network call on the worker thread
                .subscribeOn(Schedulers.io())
//                    get the results back on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RemoteObserver(callback));


    }
}
