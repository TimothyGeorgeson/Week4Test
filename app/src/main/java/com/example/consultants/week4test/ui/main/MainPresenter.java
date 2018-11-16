package com.example.consultants.week4test.ui.main;

import android.util.Log;

import com.example.consultants.week4test.model.NYResponse.School;
import com.example.consultants.week4test.model.remote.NYCallback;
import com.example.consultants.week4test.model.remote.NYRepository;

import java.util.List;

public class MainPresenter implements MainContract.Presenter{
    public static final String TAG = MainPresenter.class.getSimpleName() + "_TAG";

    MainContract.View view;
    NYRepository repository;

    public MainPresenter(NYRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getSchools() {

        repository.getSchools(new NYCallback() {
            @Override
            public void onSuccess(List<School> schoolList) {
                Log.d(TAG, "onSuccess: " + schoolList.size());
                view.onSchools(schoolList);
            }

            @Override
            public void onFailure(String error) {
                view.showError(error);

            }
        });

    }


    @Override
    public void onAttach(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

}
