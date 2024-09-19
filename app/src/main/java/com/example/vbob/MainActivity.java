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

public class MainActivity extends AppCompatActivity {

    Button loginhome;
    Button facultyloginhome;


    public void loginMessage(View view)
    {
        Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show();
    }
    public void SignUpMessage(View view)
    {
        Toast.makeText(this, "Signing up...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            loginhome=findViewById(R.id.StudentLoginButton);
            loginhome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1=new Intent(MainActivity.this,CombinedLogin.class);
                    startActivity(intent1);
                }

            });
            facultyloginhome=findViewById(R.id.FacultyLoginButton);
            facultyloginhome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2=new Intent(MainActivity.this,Signuppage.class);
                    startActivity(intent2);
                }
            });
            return insets;
        });
    }
}