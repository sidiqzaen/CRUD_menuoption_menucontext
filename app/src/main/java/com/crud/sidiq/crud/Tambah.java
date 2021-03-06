package com.crud.sidiq.crud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class Tambah extends Activity {
    EditText kampusName,alamat;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        kampusName = (EditText) findViewById(R.id.txtKampusName);
        alamat = (EditText) findViewById(R.id.txtAlamat);
    }

    public void addNewKampus(View view) {
        HashMap<String, String> queryValues =  new  HashMap<String, String>();
        queryValues.put("kampusName", kampusName.getText().toString());
        queryValues.put("alamat", alamat.getText().toString());
        controller.addKampus(queryValues);
        this.callHomeActivity(view);
    }
    /* panggil MainActivity */
    public void callHomeActivity(View view) {
        Intent objIntent = new Intent(getApplicationContext(), Home.class);
        startActivity(objIntent);
    }
}
