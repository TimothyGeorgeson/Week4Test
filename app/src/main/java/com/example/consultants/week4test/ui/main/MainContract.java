package com.example.consultants.week4test.ui.main;

import com.example.consultants.week4test.model.NYResponse.School;
import com.example.consultants.week4test.ui.base.BasePresenter;
import com.example.consultants.week4test.ui.base.BaseView;

import java.util.List;

public interface MainContract {

    interface View extends BaseView {

        void onSchools(List<School> schoolList);
    }

    interface Presenter extends BasePresenter<View> {

        void getSchools();
    }
}
