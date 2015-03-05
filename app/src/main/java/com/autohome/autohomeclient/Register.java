package com.autohome.autohomeclient;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Register extends ActionBarActivity {

	private EditText usernameEditText;
	private EditText emailEditText;
	private EditText passwordEditText;
	private EditText confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle("AutoHome");

		usernameEditText = (EditText) findViewById(R.id.register_username);
		emailEditText = (EditText) findViewById(R.id.register_email);
		passwordEditText = (EditText) findViewById(R.id.register_password);
		confirmPasswordEditText = (EditText) findViewById(R.id.register_password_confirm);

		confirmPasswordEditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (!s.equals(passwordEditText.getText())) {
					confirmPasswordEditText.setError("Passwords don't match");
				}
			}

		});
    }

	public void register (View view) {
		startActivity(new Intent(this, Rooms.class));
	}


}
