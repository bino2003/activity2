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
ActivityEditActiviyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEditActiviyBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ActivityResultLauncher<Intent>   arl=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                binding.etCourseHours.setText(result.getData().getIntExtra("CourseHours",0));
                binding.etCourseName.setText(result.getData().getStringExtra("CourseName"));
                binding.etCourseSemester.setText(result.getData().getIntExtra("Course_semester",0));

            }
        });

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EditActivity.this,Item_Course.class);
                arl.launch(intent);



            }
        });




    }
}