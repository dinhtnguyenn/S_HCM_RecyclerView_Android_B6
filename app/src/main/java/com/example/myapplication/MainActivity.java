package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.adapter.StudentAdapter;
import com.example.myapplication.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnChange;
    private  ArrayList<Student> alStudents;

    private RecyclerView rclStudentList;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rclStudentList = findViewById(R.id.rclStudentList);
        btnChange = findViewById(R.id.btnChange);

        //data mẫu
        alStudents = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            alStudents.add(new Student(i, "Student " + i, "Address " + i, "098xxx"));
        }

        rclStudentList.setHasFixedSize(true);

        /**
         * thay đổi adapter
         */
        studentAdapter = new StudentAdapter(alStudents, MainActivity.this, new StudentAdapter.StudentAdapterListener() {
            @Override
            public void click(View v, int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rclStudentList.setLayoutManager(linearLayoutManager);
        rclStudentList.setAdapter(studentAdapter);



    }
}