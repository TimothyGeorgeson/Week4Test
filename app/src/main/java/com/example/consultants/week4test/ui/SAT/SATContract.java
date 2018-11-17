package com.example.consultants.week4test.ui.SAT;

import com.example.consultants.week4test.model.NYResponse.SAT;
import com.example.consultants.week4test.model.NYResponse.School;
import com.example.consultants.week4test.ui.base.BasePresenter;
import com.example.consultants.week4test.ui.base.BaseView;

import java.util.List;

public interface SATContract {

    interface View extends BaseView {

        void onSATScores(List<SAT> scores);
    }

    interface Presenter extends BasePresenter<SATContract.View> {

        void getSATScores();
    }
}
