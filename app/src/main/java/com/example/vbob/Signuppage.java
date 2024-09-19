package com.example.vbob;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signuppage extends AppCompatActivity {


    Button studentsignupbutton;
    Button facultysignupbutton;


    public void SignUpMessage(View view)
    {
        Toast.makeText(this, "Signing Up...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signuppage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            studentsignupbutton=findViewById(R.id.StudentLoginButton);
            studentsignupbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Signuppage.this,Studentsignuppage.class);
                    startActivity(intent);
                }
            });
            facultysignupbutton=findViewById(R.id.FacultyLoginButton);
            facultysignupbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Signuppage.this,Facultysignuppage.class);
                    startActivity(intent);
                }
            });











            return insets;
        });
    }
}