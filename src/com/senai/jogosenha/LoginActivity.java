package com.senai.jogosenha;

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
		
		Intent intent = new Intent(this, RankingActivity.class);
		intent.putExtra("email", email);
		startActivity(intent);
	}

}