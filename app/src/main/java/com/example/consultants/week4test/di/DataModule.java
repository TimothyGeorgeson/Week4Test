package com.example.consultants.week4test.di;

import com.example.consultants.week4test.model.remote.NYRepository;
import com.example.consultants.week4test.model.remote.RemoteDataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    RemoteDataSource providesRemoteDataSource() {
        return new RemoteDataSource();
    }

    @Provides
    NYRepository providesRandomRepository(RemoteDataSource remoteDataSource) {
        return new NYRepository(remoteDataSource);
    }
}
