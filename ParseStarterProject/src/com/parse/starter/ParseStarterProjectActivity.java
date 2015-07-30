package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.starter.R;

public class ParseStarterProjectActivity extends Activity {
	public EditText editNome, editTelefone, editEmail, editCurso, editSenha;
	public Button btnCadastrar;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		editNome = (EditText) findViewById(R.id.nome);
		editTelefone = (EditText) findViewById(R.id.telefone);
		editEmail = (EditText) findViewById(R.id.email);
        editCurso = (EditText) findViewById(R.id.curso);
        editSenha = (EditText) findViewById(R.id.senha);
		btnCadastrar = (Button) findViewById(R.id.cadastrar);

		btnCadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    ParseUser user = new ParseUser();
                    user.setUsername(editNome.getText().toString());
                    user.setEmail(editEmail.getText().toString());
                    user.setPassword(editSenha.getText().toString());

                    user.put("curso", editCurso.getText().toString());
                    user.put("telefone", Float.parseFloat(editTelefone.getText().toString()));

                    user.signUp();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
	}
}
