package com.example.jr.segundaaplicacao;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mudarCor(View v) {
        RelativeLayout corView = (RelativeLayout) findViewById(R.id.minhaView);
        Random rand = new Random();
        String chars = "0123456789ABCDEF";
        StringBuilder cor = new StringBuilder("#");
        cor.append(chars.charAt(rand.nextInt(16)))
                .append(chars.charAt(rand.nextInt(16)))
                .append(chars.charAt(rand.nextInt(16)))
                .append(chars.charAt(rand.nextInt(16)))
                .append(chars.charAt(rand.nextInt(16)))
                .append(chars.charAt(rand.nextInt(16)));
        corView.setBackgroundColor(Color.parseColor(cor.toString()));
    }

    public void mudarNome (View view){
        List <String> nomes = new LinkedList <String> ();
        nomes.add("Junior");
        nomes.add("Del");
        nomes.add("Graça");
        nomes.add("Josa");
        nomes.add("Jardy");

        int num = new Random().nextInt(5);

        TextView objetoTexto = (TextView) findViewById(R.id.textoMudar);
        objetoTexto.setText(nomes.get(num));
    }

    public void next (View v) {
        setContentView(R.layout.tela2);
    }

    public void voltar (View v) {
        setContentView(R.layout.content_main);
    }

    public void sortNum (View v) {
        TextView num = (TextView) findViewById(R.id.numero);
        num.setText(Integer.toString(new Random().nextInt(101)));
    }

    public void login (View v) {

        EditText usu = (EditText) findViewById(R.id.usuario);
        EditText s = (EditText) findViewById(R.id.senha);
        String usuario = usu.getText().toString();
        String senha = s.getText().toString();

        if (usuario.equals("junior") && senha.equals("lol")){
            AlertDialog a = new AlertDialog.Builder(this).create();
            a.setTitle("Login Realizado com Sucesso!");
            a.show();
            setContentView(R.layout.tela2);
        } else {
            loginErrado();
        }

    }

    public void loginErrado() {
        AlertDialog alerta = new AlertDialog.Builder(this).create();
        alerta.setTitle("Login incorreto!");
        alerta.setMessage("O nome de usuário ou a senha está incorreto!");
        alerta.show();
    }
}
