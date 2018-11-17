package com.example.consultants.week4test.model.remote.sat;

import com.example.consultants.week4test.model.NYResponse.SAT;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RemoteObserverSAT implements Observer<List<SAT>> {

        SATCallback callback;

        public RemoteObserverSAT(SATCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<SAT> scores) {

            callback.onSuccess(scores);
        }

        @Override
        public void onError(Throwable e) {

            callback.onFailure(e.getMessage());
        }

        @Override
        public void onComplete() {

        }
}
