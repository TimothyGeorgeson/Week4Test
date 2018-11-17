package com.example.consultants.week4test.di;

import com.example.consultants.week4test.ui.SAT.SATActivity;

import dagger.Component;

@Component(modules = SATModule.class)
public interface SATComponent {

    void inject(SATActivity satActivity);
}
