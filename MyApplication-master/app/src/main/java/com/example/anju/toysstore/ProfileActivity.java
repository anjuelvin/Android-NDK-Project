package com.example.anju.toysstore;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import butterknife.InjectView;

public class ProfileActivity extends AppCompatActivity {

    @InjectView(R.id.btn_login)
    Button _loginButton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        {
            Intent shoppingIntent = new Intent(ProfileActivity.this, ShoppingActivity.class);
            startActivity(shoppingIntent);
        }

        int id = item.getItemId();


        if (id == R.id.action_item1) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }






}
