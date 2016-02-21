package com.example.deyvison.roteiro01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText mNomeText,mSobrenometext,mUsuarioText,mSenhaText,mConfirmarSenhaText;
    private Button mCasdastrarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.mNomeText = (EditText) findViewById(R.id.nomeText);
        this.mSobrenometext = (EditText) findViewById(R.id.sobrenomeText);
        this.mUsuarioText = (EditText) findViewById(R.id.usuarioTexto);
        this.mSenhaText = (EditText) findViewById(R.id.senhaText);
        this.mConfirmarSenhaText = (EditText) findViewById(R.id.confirmarSenhaText);
        this.mCasdastrarButton = (Button) findViewById(R.id.cadastrarButton);

        mCasdastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validarCadastro()){
                    cadastrar();
                };
            }
        });
    }

    public boolean validarCadastro(){

        String nome,sobreNome,usuario,senha,confirmarSenha;

        nome = this.mNomeText.getText().toString();
        sobreNome = this.mSobrenometext.getText().toString();
        usuario = this.mUsuarioText.getText().toString();
        senha = this.mSenhaText.getText().toString();
        confirmarSenha = this.mConfirmarSenhaText.getText().toString();

        View focus = null;
        String msgErro = "Campo vazio!";
        boolean valido = true;

        if(nome.isEmpty()){
            mNomeText.setError(msgErro);
            focus = mNomeText;
            focus.requestFocus();
            valido = false;
        }if(sobreNome.isEmpty()){
            mSobrenometext.setError(msgErro);
            focus = mSobrenometext;
            focus.requestFocus();
            valido = false;
        }if(usuario.isEmpty()){
            mUsuarioText.setError(msgErro);
            focus = mUsuarioText;
            focus.requestFocus();
            valido = false;
        }if(senha.isEmpty()){
            mSenhaText.setError(msgErro);
            focus = mSenhaText;
            focus.requestFocus();
            valido = false;
        }if(confirmarSenha.isEmpty()){
            mConfirmarSenhaText.setError(msgErro);
            focus = mConfirmarSenhaText;
            focus.requestFocus();
            valido = false;
        }if(!senha.isEmpty()&& !confirmarSenha.isEmpty() && !senha.equals(confirmarSenha)){
            mSenhaText.setError("Senhas não conferem!");
            focus = mSenhaText;
            focus.requestFocus();
            valido = false;
        }
        return valido;
    }

    public void cadastrar(){
        Intent i = new Intent(this,MainActivity.class);
        Bundle b = new Bundle();
        b.putString("usuario",this.mUsuarioText.getText().toString());
        i.putExtras(b);
        startActivity(i);
        finish();
    }
}
