package com.example.consultants.week4test.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.consultants.week4test.R;
import com.example.consultants.week4test.model.NYResponse.School;
import com.example.consultants.week4test.model.remote.NYRepository;
import com.example.consultants.week4test.model.remote.RemoteDataSource;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    RecyclerView rvVenueList;
    RecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(new NYRepository(new RemoteDataSource()));

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttach(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onDetach();
    }


    public void onShowSchools(View view) {
        presenter.getSchools();
    }

    @Override
    public void onSchools(List<School> schoolList) {
        adapter = new RecyclerViewAdapter(schoolList);
        layoutManager = new LinearLayoutManager(this);
        rvVenueList = findViewById(R.id.rvSchoolList);
        rvVenueList.setAdapter(adapter);
        rvVenueList.setLayoutManager(layoutManager);
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: " + error);
    }
}
