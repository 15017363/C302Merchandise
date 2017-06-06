package com.example.a15017363.c302merchandise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

public class DisplayItemInfoActivity extends AppCompatActivity {

    private String userId;
    private EditText etItemName, etPrice,etQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item_info);



    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        userId = intent.getStringExtra("com.example.MAIN_MESSAGE");
        HttpRequest request= new HttpRequest("http://10.0.2.2/C302_P07/getItemById.php?Id="+ userId);
        request.setMethod("GET");
        request.execute();

        try{
            String jsonString = request.getResponse();
            JSONObject jsonObj = new JSONObject(jsonString);
            // TODO 01: Set values in the EditText fields

            etItemName = (EditText)findViewById(R.id.editTextItemName);
            etPrice = (EditText)findViewById(R.id.editTextPrice);
            etQuantity = (EditText)findViewById(R.id.editTextQuantity);

            etItemName.setText(jsonObj.getString("item_name"));
            etPrice.setText(jsonObj.getString("quantity"));
            etQuantity.setText(jsonObj.getString("price"));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRecordButtonClicked(View view){

        etItemName = (EditText)findViewById(R.id.editTextItemName);
        etPrice = (EditText)findViewById(R.id.editTextPrice);
        etQuantity = (EditText)findViewById(R.id.editTextQuantity);

        //TODO 03: Send the HttpRequest to updateContact.php
        HttpRequest request = new HttpRequest("http://10.0.2.2/C302_P07/updateItemById.php");
        request.setMethod("POST");
        request.addData("id",userId);
        request.addData("item_name",etItemName.getText().toString());
        request.addData("quantity",etQuantity.getText().toString());
        request.addData("price",etPrice.getText().toString());
        request.execute();

        try{
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRecordButtonClicked(View view){
        //TODO 04: Send HttpRequest to removeContact.php
        HttpRequest request = new HttpRequest("http://10.0.2.2/C302_P07/deleteItem.php");
        request.setMethod("POST");
        request.addData("Id",userId);
        request.execute();



        try{


            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
