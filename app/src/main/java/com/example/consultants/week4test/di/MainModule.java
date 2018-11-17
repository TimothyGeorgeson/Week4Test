package com.example.consultants.week4test.di;

import com.example.consultants.week4test.model.remote.NYRepository;
import com.example.consultants.week4test.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module(includes = DataModule.class)
public class MainModule {

    @Provides
    MainPresenter providesMainPresenter(NYRepository nyRepository) {
        return new MainPresenter(nyRepository);
    }
}
