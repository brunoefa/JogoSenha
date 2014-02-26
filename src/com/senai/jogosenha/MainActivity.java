package com.senai.jogosenha;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int STATUS_PARCIALMENTE_CORRETO 	= R.drawable.icone_parcialmente_correto;
	private static final int STATUS_COMPLETAMENTE_CORRETO 	= R.drawable.icone_completamente_correto;
	private static final int STATUS_ERRADO 					= R.drawable.icone_errado;
	private int[] status = { 0, 0, 0, 0 };

	private String senha;
	private Integer linha = 0;
	private String[][] listaSenha = new String[6][4];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		gerarSenha();
		mostrar(senha);
		verificarStatus();
		alterarStatus();

	}

	public void verificarStatus() {
		capturarSenha(linha);

		char[] splitSenha = senha.toCharArray();

		for (int coluna = 0; coluna < 4; coluna++) {
			String digitoSenha = String.valueOf(splitSenha[coluna]);
			String digitoLinha = listaSenha[linha][coluna];

			status[coluna] = STATUS_ERRADO;

			if (senha.contains(digitoLinha)) {
				status[coluna] = STATUS_PARCIALMENTE_CORRETO;
			}

			if (digitoSenha.equals(digitoLinha)) {
				status[coluna] = STATUS_COMPLETAMENTE_CORRETO;
			}

		}
	}

	private void alterarStatus() {
		for (int coluna = 0; coluna < 4; coluna++) {
			inserirStatus(linha, coluna, status[coluna]);
		}
		mostrarStatus(linha);
	}
	

	public void gerarSenha() {
		String s = "";
		for (int i = 0; i < 4; i++) {
			Random random = new Random();
			int digito = random.nextInt(9 - 0);
			s += String.valueOf(digito);
		}
		senha = s;
	}

	public void capturarSenha(int linha) {
		for (int coluna = 0; coluna < 4; coluna++) {
			listaSenha[linha][coluna] = capturarDigito(linha, coluna);
		}
	}
	
	private void mostrarStatus(int linha) {
		LinearLayout statusLayout = new LinearLayout(this);
		switch (linha) {
		case 0: statusLayout = (LinearLayout)findViewById(R.id.line0); break;
		case 1: statusLayout = (LinearLayout)findViewById(R.id.line1); break;
		case 2: statusLayout = (LinearLayout)findViewById(R.id.line2); break;
		case 3: statusLayout = (LinearLayout)findViewById(R.id.line3); break;
		case 4: statusLayout = (LinearLayout)findViewById(R.id.line4); break;
		case 5: statusLayout = (LinearLayout)findViewById(R.id.line5); break;
		}
		statusLayout.setVisibility(LinearLayout.VISIBLE);
	}
	
	public void inserirStatus(int linha, int coluna, int status) {
		if (linha == 0 && coluna == 0) {((ImageView)findViewById(R.id.img_statusl00)).setImageResource(status);}
		if (linha == 1 && coluna == 0) {((ImageView)findViewById(R.id.img_statusl10)).setImageResource(status);}
		if (linha == 2 && coluna == 0) {((ImageView)findViewById(R.id.img_statusl20)).setImageResource(status);}
		if (linha == 3 && coluna == 0) {((ImageView)findViewById(R.id.img_statusl30)).setImageResource(status);}
		if (linha == 4 && coluna == 0) {((ImageView)findViewById(R.id.img_statusl30)).setImageResource(status);}
		if (linha == 5 && coluna == 0) {((ImageView)findViewById(R.id.img_statusl40)).setImageResource(status);}
		
		if (linha == 0 && coluna == 1) {((ImageView)findViewById(R.id.img_statusl01)).setImageResource(status);}
		if (linha == 1 && coluna == 1) {((ImageView)findViewById(R.id.img_statusl11)).setImageResource(status);}
		if (linha == 2 && coluna == 1) {((ImageView)findViewById(R.id.img_statusl21)).setImageResource(status);}
		if (linha == 3 && coluna == 1) {((ImageView)findViewById(R.id.img_statusl31)).setImageResource(status);}
		if (linha == 4 && coluna == 1) {((ImageView)findViewById(R.id.img_statusl41)).setImageResource(status);}
		if (linha == 5 && coluna == 1) {((ImageView)findViewById(R.id.img_statusl51)).setImageResource(status);}
		
		if (linha == 0 && coluna == 2) {((ImageView)findViewById(R.id.img_statusl02)).setImageResource(status);}
		if (linha == 1 && coluna == 2) {((ImageView)findViewById(R.id.img_statusl12)).setImageResource(status);}
		if (linha == 2 && coluna == 2) {((ImageView)findViewById(R.id.img_statusl22)).setImageResource(status);}
		if (linha == 3 && coluna == 2) {((ImageView)findViewById(R.id.img_statusl32)).setImageResource(status);}
		if (linha == 4 && coluna == 2) {((ImageView)findViewById(R.id.img_statusl42)).setImageResource(status);}
		if (linha == 5 && coluna == 2) {((ImageView)findViewById(R.id.img_statusl52)).setImageResource(status);}
		
		if (linha == 0 && coluna == 3) {((ImageView)findViewById(R.id.img_statusl03)).setImageResource(status);}
		if (linha == 1 && coluna == 3) {((ImageView)findViewById(R.id.img_statusl13)).setImageResource(status);}
		if (linha == 2 && coluna == 3) {((ImageView)findViewById(R.id.img_statusl23)).setImageResource(status);}
		if (linha == 3 && coluna == 3) {((ImageView)findViewById(R.id.img_statusl33)).setImageResource(status);}
		if (linha == 4 && coluna == 3) {((ImageView)findViewById(R.id.img_statusl43)).setImageResource(status);}
		if (linha == 5 && coluna == 3) {((ImageView)findViewById(R.id.img_statusl53)).setImageResource(status);}
	}
	
	public String capturarDigito(int linha, int coluna) {
		String digito = "";
		if (linha == 0 && coluna == 0) {digito = ((EditText)findViewById(R.id.editTextl00)).getText().toString();}
		if (linha == 1 && coluna == 0) {digito = ((EditText)findViewById(R.id.editTextl10)).getText().toString();}
		if (linha == 2 && coluna == 0) {digito = ((EditText)findViewById(R.id.editTextl20)).getText().toString();}
		if (linha == 3 && coluna == 0) {digito = ((EditText)findViewById(R.id.editTextl30)).getText().toString();}
		if (linha == 4 && coluna == 0) {digito = ((EditText)findViewById(R.id.editTextl40)).getText().toString();}
		if (linha == 5 && coluna == 0) {digito = ((EditText)findViewById(R.id.editTextl50)).getText().toString();}
		
		if (linha == 0 && coluna == 1) {digito = ((EditText)findViewById(R.id.editTextl01)).getText().toString();}
		if (linha == 1 && coluna == 1) {digito = ((EditText)findViewById(R.id.editTextl11)).getText().toString();}
		if (linha == 2 && coluna == 1) {digito = ((EditText)findViewById(R.id.editTextl21)).getText().toString();}
		if (linha == 3 && coluna == 1) {digito = ((EditText)findViewById(R.id.editTextl31)).getText().toString();}
		if (linha == 4 && coluna == 1) {digito = ((EditText)findViewById(R.id.editTextl41)).getText().toString();}
		if (linha == 5 && coluna == 1) {digito = ((EditText)findViewById(R.id.editTextl51)).getText().toString();}
		
		if (linha == 0 && coluna == 2) {digito = ((EditText)findViewById(R.id.editTextl02)).getText().toString();}
		if (linha == 1 && coluna == 2) {digito = ((EditText)findViewById(R.id.editTextl12)).getText().toString();}
		if (linha == 2 && coluna == 2) {digito = ((EditText)findViewById(R.id.editTextl22)).getText().toString();}
		if (linha == 3 && coluna == 2) {digito = ((EditText)findViewById(R.id.editTextl32)).getText().toString();}
		if (linha == 4 && coluna == 2) {digito = ((EditText)findViewById(R.id.editTextl42)).getText().toString();}
		if (linha == 5 && coluna == 2) {digito = ((EditText)findViewById(R.id.editTextl52)).getText().toString();}
		
		if (linha == 0 && coluna == 3) {digito = ((EditText)findViewById(R.id.editTextl03)).getText().toString();}
		if (linha == 1 && coluna == 3) {digito = ((EditText)findViewById(R.id.editTextl13)).getText().toString();}
		if (linha == 2 && coluna == 3) {digito = ((EditText)findViewById(R.id.editTextl23)).getText().toString();}
		if (linha == 3 && coluna == 3) {digito = ((EditText)findViewById(R.id.editTextl33)).getText().toString();}
		if (linha == 4 && coluna == 3) {digito = ((EditText)findViewById(R.id.editTextl43)).getText().toString();}
		if (linha == 5 && coluna == 3) {digito = ((EditText)findViewById(R.id.editTextl53)).getText().toString();}
		return digito;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void mostrar(String mensagem) {
		Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
	}
}