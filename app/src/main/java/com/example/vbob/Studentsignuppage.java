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

public class Studentsignuppage extends AppCompatActivity {

    Button signup_button;
    EditText reg_no_input,name_input,branch_input,passsword_input,bus_input;
    public void signupmessage(View view)
    {
        Toast.makeText(this, "Signing up", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_studentsignuppage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            reg_no_input=findViewById(R.id.editTextText);
            name_input=findViewById(R.id.editTextText2);
            branch_input=findViewById(R.id.editTextText3);
            passsword_input=findViewById(R.id.editTextTextPassword2);
            bus_input=findViewById(R.id.editTextText4);
            signup_button=findViewById(R.id.b1);
            signup_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Signupdatabase mydb=new Signupdatabase(Studentsignuppage.this);
                    mydb.add_details(reg_no_input.getText().toString(),
                            name_input.getText().toString(),
                            branch_input.getText().toString(),
                            passsword_input.getText().toString(),bus_input.getText().toString());

                        Intent intent=new Intent(Studentsignuppage.this,Studentloginpage.class);
                        startActivity(intent);
                }
            });
            return insets;
        });

    }
}