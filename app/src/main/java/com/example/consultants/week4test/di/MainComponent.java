package com.example.consultants.week4test.di;

import com.example.consultants.week4test.ui.main.MainActivity;

import dagger.Component;

@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
