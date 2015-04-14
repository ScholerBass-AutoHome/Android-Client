package com.autohome.autohomeclient;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class StartScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle("AutoHome");
    }

    public void launch_login(View view) {
        startActivity(new Intent(this, Login.class));
    }

	public void launch_register(View view) {
		startActivity(new Intent(this, Register.class));
	}

	public void bypass(View view) {
		startActivity(new Intent(this, MainActivity.class));
	}
}
