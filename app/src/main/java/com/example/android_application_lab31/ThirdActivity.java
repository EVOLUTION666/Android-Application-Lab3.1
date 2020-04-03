package com.example.android_application_lab31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThirdActivity extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    EditText editFirstName, editMiddleName, editLastName, editDate;
    Button btnAddData;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = format.format( new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        editFirstName = (EditText)findViewById(R.id.editTextName);
        editMiddleName = (EditText)findViewById(R.id.editTextName2);
        editLastName = (EditText)findViewById(R.id.editTextName3);
        btnAddData = (Button)findViewById(R.id.AddButton);

        AddData();
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.addContact(new Contact(editFirstName.getText().toString(), editMiddleName.getText().toString(), editLastName.getText().toString(), dateString.toString()));
                    }
                }
        );
    }

}

