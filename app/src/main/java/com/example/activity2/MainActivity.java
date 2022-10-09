package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.activity2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnAction {
    ActivityMainBinding binding;
    Course_adapter course_adapter;
    ArrayList<course> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        courses.add(new course("UiUx", 3, 1));
        courses.add(new course("Web Programming", 3, 1));
        courses.add(new course("English IT", 3, 1));
        course_adapter = new Course_adapter(courses, this);


        binding.rvCourse.setAdapter(course_adapter);
        binding.rvCourse.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));


    }

    @Override
    public void onDelete(int position) {
        courses.remove(position);
        course_adapter.notifyItemRemoved(position);
    }

    @Override
    public void onEdit(int Position) {


        int CourseHours = courses.get(Position).getCourse_hours();
        int CourseSemester = courses.get(Position).getCourse_semester();
        String CourseName = courses.get(Position).getCourse_name();


        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("Course_semester", CourseSemester);
        intent.putExtra("CourseHours", CourseHours);
        intent.putExtra("CourseName", CourseName);
        intent.putExtra("position", Position);
        //setResult(RESULT_OK,intent);
        MainActivity.this.startActivity(intent);
        finish();


    }
    private void updateAtGivenPosition(int position){
        course c = courses.get(position);
        //getIntent().getStringExtra()
        //c.setCourse_hours();
    }


}