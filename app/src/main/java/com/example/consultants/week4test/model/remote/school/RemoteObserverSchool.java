package com.example.consultants.week4test.model.remote.school;

import com.example.consultants.week4test.model.NYResponse.School;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RemoteObserverSchool implements Observer<List<School>> {

    SchoolCallback callback;

    public RemoteObserverSchool(SchoolCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<School> schoolList) {

        callback.onSuccess(schoolList);
    }

    @Override
    public void onError(Throwable e) {

        callback.onFailure(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
