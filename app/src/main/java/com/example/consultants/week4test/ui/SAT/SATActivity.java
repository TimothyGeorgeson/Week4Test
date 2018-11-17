package com.example.consultants.week4test.ui.SAT;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.consultants.week4test.R;
import com.example.consultants.week4test.model.NYResponse.SAT;
import com.example.consultants.week4test.model.remote.NYRepository;
import com.example.consultants.week4test.model.remote.RemoteDataSource;

import java.util.List;

public class SATActivity extends AppCompatActivity implements SATContract.View {
    public static final String TAG = SATActivity.class.getSimpleName() + "_TAG";
    public static final String SCHOOL_DBN = "SchoolDBN";

    TextView tvSATName;
    TextView tvSATMath;
    TextView tvSATReading;
    TextView tvSATWriting;
    SATPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sat);

        tvSATName = findViewById(R.id.tvSATName);
        tvSATMath = findViewById(R.id.tvSATMath);
        tvSATReading = findViewById(R.id.tvSATReading);
        tvSATWriting = findViewById(R.id.tvSATWriting);

        presenter = new SATPresenter(new NYRepository(new RemoteDataSource()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttach(this);
        presenter.getSATScores();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onDetach();
    }

    @Override
    public void onSATScores(List<SAT> scores) {
        String dbn = getIntent().getStringExtra(SCHOOL_DBN);
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i).getDbn().equals(dbn))
            {
                tvSATName.setText(scores.get(i).getSchoolName());
                tvSATMath.setText("Math: " + scores.get(i).getSatMathAvgScore());
                tvSATReading.setText("Reading: " + scores.get(i).getSatCriticalReadingAvgScore());
                tvSATWriting.setText("Writing: " + scores.get(i).getSatWritingAvgScore());
            }
        }

        if (tvSATMath.getText().equals("Math: ")) tvSATMath.setText("Math: Unknown");
        if (tvSATReading.getText().equals("Reading: ")) tvSATReading.setText("Reading: Unknown");
        if (tvSATWriting.getText().equals("Writing: ")) tvSATWriting.setText("Writing: Unknown");

    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: " + error);
    }
}
