package com.example.consultants.week4test.di;

import com.example.consultants.week4test.model.remote.NYRepository;
import com.example.consultants.week4test.ui.SAT.SATPresenter;
import com.example.consultants.week4test.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module(includes = DataModule.class)
public class SATModule {

    @Provides
    SATPresenter providesSATPresenter(NYRepository nyRepository) {
        return new SATPresenter(nyRepository);
    }
}


