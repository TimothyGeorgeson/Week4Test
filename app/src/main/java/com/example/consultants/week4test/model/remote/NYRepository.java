package com.example.consultants.week4test.model.remote;

import com.example.consultants.week4test.model.remote.sat.RemoteObserverSAT;
import com.example.consultants.week4test.model.remote.sat.SATCallback;
import com.example.consultants.week4test.model.remote.school.RemoteObserverSchool;
import com.example.consultants.week4test.model.remote.school.SchoolCallback;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NYRepository {

    RemoteDataSource remoteDataSource;

    public NYRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void getSchools(final SchoolCallback callback) {

        remoteDataSource.getSchoolObs()
//                    make the network call on the worker thread
                .subscribeOn(Schedulers.io())
//                    get the results back on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RemoteObserverSchool(callback));

    }

    public void getScores(final SATCallback callback) {

        remoteDataSource.getScoreObs()
//                    make the network call on the worker thread
                .subscribeOn(Schedulers.io())
//                    get the results back on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RemoteObserverSAT(callback));

    }
}
