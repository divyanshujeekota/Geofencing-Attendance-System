package com.example.vbob;

import static android.app.ProgressDialog.show;

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

public class CombinedLogin extends AppCompatActivity {

    Button studentloginbutton;
    Button facultyloginbutton;



    public void LoginMessage(View view)
    {
        Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_combined_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            studentloginbutton=findViewById(R.id.StudentLoginButton);
            studentloginbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(CombinedLogin.this,Studentloginpage.class);
                    startActivity(intent);
                }
            });
            facultyloginbutton=findViewById(R.id.FacultyLoginButton);
            facultyloginbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(CombinedLogin.this,Facultyloginpage.class);
                    startActivity(intent);
                }
            });










            return insets;
        });
    }
}