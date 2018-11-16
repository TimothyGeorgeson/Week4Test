package com.example.consultants.week4test.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.week4test.R;
import com.example.consultants.week4test.model.NYResponse.School;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<School> schoolList;

    public RecyclerViewAdapter(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflate view
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int i) {
        School school = schoolList.get(i);

        viewHolder.tvName.setText("Name: " + school.getSchoolName());
        viewHolder.tvCity.setText("City: " + school.getCity());
        viewHolder.tvGrades.setText("Grades: " + school.getGrades2018());
        viewHolder.tvWebsite.setText("Rating: " + school.getWebsite());
    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvCity;
        private final TextView tvGrades;
        private final TextView tvWebsite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvCity = itemView.findViewById(R.id.tvCity);
            tvGrades = itemView.findViewById(R.id.tvGrades);
            tvWebsite = itemView.findViewById(R.id.tvWebsite);
        }
    }
}
