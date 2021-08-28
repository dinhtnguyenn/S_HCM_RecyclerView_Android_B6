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

        //thiết lập để cuộn mượt hơn
        rclStudentList.setHasFixedSize(true);

        studentAdapter = new StudentAdapter(alStudents, MainActivity.this);

        //==================LINEAR==========================================
        // sử dụng LayoutManager để quy định kiểu hiển thị cho list (ngang/dọc)
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        //Thiết lập phần tử hiển thị mặc định nếu muốn
        //linearLayoutManager.scrollToPosition(10);

        rclStudentList.setLayoutManager(linearLayoutManager);
        rclStudentList.setAdapter(studentAdapter);


        //==================GRID==========================================
        //2: Số cột nếu thiết lập lưới đứng, số dòng nếu lưới ngang
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//
//        //GridLayoutManager.VERTICAL: lưới dọc | GridLayoutManager.HORIZONTAL: lưới ngang
//        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
//        rclStudentList.setLayoutManager(gridLayoutManager);
//        rclStudentList.setAdapter(studentAdapter);

//==================STAGGER GRID==========================================
//        StaggeredGridLayoutManager gridLayoutManager =
//                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        rclStudentList.setLayoutManager(gridLayoutManager);
//        rclStudentList.setAdapter(studentAdapter);


        btnChange.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                //Thay đổi thông tin sinh viên ở vị trí số 3
//                Student student = alStudents.get(2);
//                student.setFullName("Thay tên nè");
//                studentAdapter.notifyItemChanged(2);



                //Thêm một sinh viên mới vào vị trí số 2
//                Student newStudent = new Student(11, "Student thêm",
//                                                    "Address", "098xxx");
//                alStudents.add(1, newStudent);
//                studentAdapter.notifyItemInserted(1);



                //Xóa sinh viên ở vị trí đầu tiên
//                alStudents.remove(0);
//                studentAdapter.notifyItemRemoved(0);



                //Ghi đè Danh sách 7 sinh viên mới
//                alStudents.clear();//Xóa bỏ danh sách cũ
//
//                //Thêm 7 sinh viên mới
//                for (int i = 1; i <= 7; i++) {
//                    alStudents.add(new Student(i, "Student Mới" + i,
//                                        "Address " + i, "098xxx"));
//                }
//
//                //Thông báo toàn bộ dữ liệu thay đổi
//                studentAdapter.notifyDataSetChanged();


                //Thêm 7 sinh viên mới vào cuối danh sách
                int positionStart = alStudents.size();

                //SV mới
                for (int i = 1; i <=7; i++)
                    alStudents.add(new Student(i, "Student Mới" + i,
                                       "Address " + i, "098xxx"));

                studentAdapter.notifyItemRangeInserted(positionStart, alStudents.size());



                Toast.makeText(MainActivity.this, "Đã thay đổi", Toast.LENGTH_SHORT).show();
            }
        });

    }
}