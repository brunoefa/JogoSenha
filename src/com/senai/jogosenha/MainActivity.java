package com.senai.jogosenha;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	// TODO Gerar senha com números únicos
	// TODO Inserir status em posições aleatórias
	// TODO Tratar última linha do jogo
	// TODO Verificar ganhador

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
	}

	public void validarSenha(View view) {
		mostrar(senha);
		verificarStatus();
		alterarStatus();
		mudarStatusLinha(linha, false);
		if (linha < 5) {
			linha++;
			mudarStatusLinha(linha, true);
		}
	}
	
	public void mudarStatusLinha(int linha, boolean status) {
		for (int coluna = 0; coluna < 4; coluna++) {
			int id = obterDigitoId(linha, coluna);
			EditText campo = (EditText)findViewById(id);
			campo.setClickable(status);
			campo.setEnabled(status);
			campo.setClickable(status);
		}
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
		Integer[] lista = {0,1,2,3};
		Vector<Integer> posicoes = new Vector<Integer>(Arrays.asList(lista));
		
		int tamanho = 3;
		for (int s = 0; s < 4; s++) {
			Random random = new Random();
			int indice;
			
			if (tamanho == 0) {
				indice = 0;
			} else {
				indice = random.nextInt(tamanho);
			}
			
			int coluna = posicoes.get(indice);
			
			inserirStatus(linha, coluna, status[s]);
			posicoes.remove(indice);
			tamanho--;
		}
		mostrarStatus(linha);
	}
	

	public void gerarSenha() {
		String[] lista = {"0","1","2","3","4","5","6","7","8","9"};
		Vector<String> universo = new Vector<String>(Arrays.asList(lista));
		
		String s = "";
		int tamanho = 9;
		for (int i = 0; i < 4; i++) {
			Random random = new Random();
			int indice = random.nextInt(tamanho - 0);
			String digito = universo.get(indice);
			s += digito;
			universo.remove(indice);
			tamanho--;
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
		int statusId = obterStatusId(linha, coluna);
		ImageView img = (ImageView)findViewById(statusId);
		img.setImageResource(status);
	}
	
	public String capturarDigito(int linha, int coluna) {
		int digitoId = obterDigitoId(linha, coluna);
		String digito = ((EditText) findViewById(digitoId)).getText().toString();
		return digito;
	}
	
	public int obterDigitoId(int linha, int coluna) {
		if (linha == 0) {
			switch (coluna) {
			case 0: return R.id.editTextl00;
			case 1: return R.id.editTextl01;
			case 2: return R.id.editTextl02;
			case 3: return R.id.editTextl03;
			}
		}
		
		if (linha == 1) {
			switch (coluna) {
			case 0: return R.id.editTextl10;
			case 1: return R.id.editTextl11;
			case 2: return R.id.editTextl12;
			case 3: return R.id.editTextl13;			
			}
		}
		if (linha == 2) {
			switch (coluna) {
			case 0: return R.id.editTextl20;
			case 1: return R.id.editTextl21;
			case 2: return R.id.editTextl22;
			case 3: return R.id.editTextl23;
			}
		}
		if (linha == 3) {
			switch (coluna) {
			case 0: return R.id.editTextl30;
			case 1: return R.id.editTextl31;
			case 2: return R.id.editTextl32;
			case 3: return R.id.editTextl33;
			}
		}
		if (linha == 4) {
			switch (coluna) {
			case 0: return R.id.editTextl40;
			case 1: return R.id.editTextl41;
			case 2: return R.id.editTextl42;
			case 3: return R.id.editTextl43;
			}
		}
		if (linha == 5) {
			switch (coluna) {
			case 0: return R.id.editTextl50;
			case 1: return R.id.editTextl51;
			case 2: return R.id.editTextl52;
			case 3: return R.id.editTextl53;
			}
		}
		return 0;
	}
	
	public int obterStatusId(int linha, int coluna) {
		if (linha == 0) {
			switch (coluna) {
			case 0: return R.id.img_statusl00;
			case 1: return R.id.img_statusl01;
			case 2: return R.id.img_statusl02;
			case 3: return R.id.img_statusl03;
			}
		}
		
		if (linha == 1) {
			switch (coluna) {
			case 0: return R.id.img_statusl10;
			case 1: return R.id.img_statusl11;
			case 2: return R.id.img_statusl12;
			case 3: return R.id.img_statusl13;			
			}
		}
		if (linha == 2) {
			switch (coluna) {
			case 0: return R.id.img_statusl20;
			case 1: return R.id.img_statusl21;
			case 2: return R.id.img_statusl22;
			case 3: return R.id.img_statusl23;
			}
		}
		if (linha == 3) {
			switch (coluna) {
			case 0: return R.id.img_statusl30;
			case 1: return R.id.img_statusl31;
			case 2: return R.id.img_statusl32;
			case 3: return R.id.img_statusl33;
			}
		}
		if (linha == 4) {
			switch (coluna) {
			case 0: return R.id.img_statusl40;
			case 1: return R.id.img_statusl41;
			case 2: return R.id.img_statusl42;
			case 3: return R.id.img_statusl43;
			}
		}
		if (linha == 5) {
			switch (coluna) {
			case 0: return R.id.img_statusl50;
			case 1: return R.id.img_statusl51;
			case 2: return R.id.img_statusl52;
			case 3: return R.id.img_statusl53;
			}
		}
		return 0;
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