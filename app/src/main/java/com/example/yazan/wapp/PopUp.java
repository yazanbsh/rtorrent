package com.example.yazan.wapp;

import android.content.Intent;
import android.nfc.tech.NfcA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pop_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void jerusalemButton_onClick(View view) {
        Intent intent=new Intent(this,Jerusalem.class);
        intent.putExtra("id",1);
        startActivity(intent);
    }

    public void RamallahButton_onClick(View view) {
        Intent intent=new Intent(this,Jerusalem.class);
        intent.putExtra("id",2);
        startActivity(intent);
    }

    public void NablusButton_onClick(View view) {
        Intent intent=new Intent(this,Jerusalem.class);
        intent.putExtra("id",3);
        startActivity(intent);
    }

    public void SalfitButton_onClick(View view) {
        Intent intent=new Intent(this,Jerusalem.class);
        intent.putExtra("id",4);
        startActivity(intent);
    }
    public void JeninButton_onClick(View view) {
        Intent intent=new Intent(this,Jerusalem.class);
        intent.putExtra("id",5);
        startActivity(intent);
    }
    public void HebronButton_onClick(View view) {
        Intent intent=new Intent(this,Jerusalem.class);
        intent.putExtra("id",6);
        startActivity(intent);    }


}
