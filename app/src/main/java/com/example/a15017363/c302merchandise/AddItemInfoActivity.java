package com.example.a15017363.c302merchandise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemInfoActivity extends AppCompatActivity {

    private EditText etItemName1, etPrice1,etQuantity1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_info);
    }

    public void addNewRecordButtonClicked(View view){
        etItemName1 = (EditText)findViewById(R.id.editTextItemName1);
        etPrice1 = (EditText)findViewById(R.id.editTextPrice1);
        etQuantity1 = (EditText)findViewById(R.id.editTextQuantity1);

        //TODO 02: Send the HttpRequest to createNewEntry.php
        HttpRequest request = new HttpRequest("http://10.0.2.2/C302_P07/addItem.php");
        request.setMethod("POST");
        request.addData("item_name",etItemName1.getText().toString());
        request.addData("quantity",etQuantity1.getText().toString());
        request.addData("price",etPrice1.getText().toString());
        request.execute();


        try{
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
