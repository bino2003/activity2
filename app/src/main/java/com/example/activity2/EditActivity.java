package com.example.activity2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.activity2.databinding.ActivityEditActiviyBinding;

public class EditActivity extends AppCompatActivity {
    private String courseName;
    private int courseSemester;
    private int courseHours;
    private int position;
    ActivityEditActiviyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditActiviyBinding.inflate(getLayoutInflater());
        getData();
        renderData();
        setContentView(binding.getRoot());
        /*
             ActivityResultLauncher<Intent> arl = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                binding.etCourseHours.setText(result.getData().getIntExtra("CourseHours", 0));
                binding.etCourseName.setText(result.getData().getStringExtra("CourseName"));
                binding.etCourseSemester.setText(result.getData().getIntExtra("Course_semester", 0));

            }
        });
         */


        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditActivity.this, Item_Course.class);

            }
        });
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int  Coursehours=  Integer.parseInt(String.valueOf(binding.etCourseHours.getText()));
                String Coursename=binding.etCourseName.getText().toString();
                int Coursesemester=Integer.parseInt(binding.etCourseSemester.getText().toString());
                Intent intent =new Intent(EditActivity.this,MainActivity.class);
                intent.putExtra("Coursehours",Coursehours);
                intent.putExtra("Coursename",Coursename);
                intent.putExtra("Coursesemester",Coursesemester);
                intent.putExtra("position",position);
                startActivity(intent);
                finishAffinity();
            }
        });


    }

    /*
            intent.putExtra("Course_semester",CourseSemester);
            intent.putExtra("CourseHours",CourseHours);
            intent.putExtra("CourseName",CourseName);
     */
    private void getData() {
        if (this.getIntent() != null) {
            Intent i = this.getIntent();
            courseName = i.getStringExtra("CourseName");
            courseHours = i.getIntExtra("CourseHours", 0);
            courseSemester = i.getIntExtra("Course_semester", 0);
            position = i.getIntExtra("position", 0);

        }
    }
    private void renderData(){
        binding.etCourseHours.setText(courseHours+"");
        binding.etCourseName.setText(courseName);
        binding.etCourseSemester.setText(courseSemester+"");

    }
}