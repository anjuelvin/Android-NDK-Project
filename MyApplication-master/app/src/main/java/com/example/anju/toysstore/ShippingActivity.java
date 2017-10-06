package com.example.anju.toysstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShippingActivity extends AppCompatActivity {
    private static final String TAG = "ShippingActivity";



    @InjectView(R.id.input_name) EditText _nameText;
    @InjectView(R.id.input_address) EditText _addressText;
    @InjectView(R.id.input_city) EditText _cityText;
    @InjectView(R.id.input_state) EditText _stateText;
    @InjectView(R.id.input_country) EditText _countryText;
    @InjectView(R.id.btn_signup) Button _signupButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);
        ButterKnife.inject(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });


    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(ShippingActivity.this
        );
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Updating Shipping details...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String address = _addressText.getText().toString();
        String city = _cityText.getText().toString();
        String state = _stateText.getText().toString();
        String country = _countryText.getText().toString();
        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        onSignupSuccess();

                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        Intent startActivityIntent = new Intent(ShippingActivity.this, CheckoutActivity.class);
        startActivity(startActivityIntent);
        ShippingActivity.this.finish();

    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }


    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String address = _addressText.getText().toString();
        String city = _cityText.getText().toString();
        String state = _stateText.getText().toString();
        String country = _countryText.getText().toString();


        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }
        if (address.isEmpty() || address.length() < 3) {
            _addressText.setError("at least 3 characters");
            valid = false;
        } else {
            _addressText.setError(null);
        }
        if (city.isEmpty() || city.length() < 3) {
            _cityText.setError("at least 3 characters");
            valid = false;
        } else {
            _cityText.setError(null);
        }
        if (state.isEmpty() || state.length() < 3) {
            _stateText.setError("at least 3 characters");
            valid = false;
        } else {
            _stateText.setError(null);
        }
        if (country.isEmpty() || country.length() < 3) {
            _countryText.setError("at least 3 characters");
            valid = false;
        } else {
            _countryText.setError(null);
        }

        return valid;
    }

}
