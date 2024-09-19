package com.example.vbob;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Studentloginpage extends AppCompatActivity {


    public void loginMessage(View view)
    {
        Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show();
    }

    EditText reg_input;
    EditText password_input;
    Button login_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_studentloginpage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            login_button=findViewById(R.id.www);
            login_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Signupdatabase mydb=new Signupdatabase(Studentloginpage.this);
                    reg_input=findViewById(R.id.reg_no_input);
                    password_input=findViewById(R.id.editTextTextPassword);
                    String reg_no=reg_input.getText().toString();
                    String password=password_input.getText().toString();
                    Boolean ans=mydb.check_regno_password(reg_no,password);
                    if (ans==true)
                    {
                        Intent intent=new Intent(getApplicationContext(),StudentPage.class);
                        String nameText=mydb.getusername(reg_no);
                        String regText=mydb.getregno(reg_no);
                        String branchText=mydb.getbranch(reg_no);
                        intent.putExtra("username",nameText);
                        intent.putExtra("regno",regText);
                        intent.putExtra("branch",branchText);
                        startActivity(intent);




                    }
                    else {
                        Toast.makeText(Studentloginpage.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            });






            return insets;
        });
    }
}