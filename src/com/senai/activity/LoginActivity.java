package com.senai.activity;

import com.senai.jogosenha.R;
import com.senai.jogosenha.R.id;
import com.senai.jogosenha.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}
	
	public void iniciarJogo(View view) {
		EditText campoLogin = (EditText)findViewById(R.id.et_login);
		String email = campoLogin.getText().toString();
		
		Intent intent = new Intent(this, JogoActivity.class);
		intent.putExtra("email", email);
		startActivity(intent);
	}

}
