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

import com.example.activity2.databinding.ActivityItemCourseBinding;

public class Item_Course extends AppCompatActivity  {
ActivityItemCourseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityItemCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

}

