package com.example.consultants.week4test.ui.SAT;

import com.example.consultants.week4test.model.NYResponse.SAT;
import com.example.consultants.week4test.model.remote.sat.SATCallback;
import com.example.consultants.week4test.model.remote.NYRepository;

import java.util.List;

public class SATPresenter implements SATContract.Presenter {

    SATContract.View view;
    NYRepository repository;

    public SATPresenter(NYRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getSATScores() {

        repository.getScores(new SATCallback() {
            @Override
            public void onSuccess(List<SAT> scores) {
                view.onSATScores(scores);
            }

            @Override
            public void onFailure(String error) {
                view.showError(error);

            }
        });
    }

    @Override
    public void onAttach(SATContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }
}
