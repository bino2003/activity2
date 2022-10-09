package com.example.activity2;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.activity2.databinding.ActivityItemCourseBinding;
import com.example.activity2.databinding.ActivityItemCourseBinding;

import java.util.ArrayList;

public class Course_adapter extends RecyclerView.Adapter<courseViewHolder> {
    ArrayList<course> courses;
    OnAction Listener;

    public Course_adapter(ArrayList<course> courses, OnAction listener) {
        this.courses = courses;
        this.Listener=listener;
    }

    @NonNull
    @Override
    public courseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        courseViewHolder courseViewHolder= new courseViewHolder
                (ActivityItemCourseBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
        return courseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull courseViewHolder holder, int position) {
        int pos=position;
        holder.courseSemester.setText(String.valueOf(courses.get(position).getCourse_semester()));
        holder.courseName.setText(courses.get(position).getCourse_name());
        holder.courseHours.setText(String.valueOf(courses.get(position).getCourse_hours()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Listener.onDelete(pos);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.itemView.setBackgroundColor(Color.RED);
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.onEdit(pos);
            }
        });


    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
class courseViewHolder extends RecyclerView.ViewHolder {
    TextView courseName;
    TextView courseHours;
    TextView courseSemester;
ImageView delete;
ImageView edit;
    public courseViewHolder(@NonNull ActivityItemCourseBinding binding) {

            super(binding.getRoot());
            courseHours=binding.tvCoursehours;
            edit=binding.IVEdit;
            delete=binding.IVDelet;

            courseName=binding.tvCoursename;
            courseSemester=binding.tvCoursesemester;



        }


}
