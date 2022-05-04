package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgEscolhaApp;
    int escolhaApp, escolhaUser, pontuacaoApp, pontuacaoUser;
    ImageButton btnPedra;
    ImageButton btnPapel;
    ImageButton btnTesoura;
    Button btnRecomecar;
    TextView teste, pontosApp, pontosUser;

    Random random = new Random();

    int[] idImage = {
        R.drawable.pedra,
        R.drawable.papel,
        R.drawable.tesoura,
        R.drawable.padrao
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        imgEscolhaApp = findViewById(R.id.imgEscolhaApp);
        btnPedra = findViewById(R.id.btnPedra);
        btnPapel = findViewById(R.id.btnPapel);
        btnTesoura = findViewById(R.id.btnTesoura);
        btnRecomecar = findViewById(R.id.btnRecomecar);
        teste = findViewById(R.id.textVS);
        pontosUser = findViewById(R.id.pontosUser);
        pontosApp = findViewById(R.id.pontosApp);

        //0 - pedra, 1 - papel, 2 - tesoura

        btnPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolhaUser=0;
                opcaoApp();
                imgEscolhaApp.setImageResource(idImage[escolhaApp]);
                ganhador();
            }
        });
        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolhaUser=1;
                opcaoApp();
                imgEscolhaApp.setImageResource(idImage[escolhaApp]);
                ganhador();
            }
        });
        btnTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolhaUser=2;
                opcaoApp();
                imgEscolhaApp.setImageResource(idImage[escolhaApp]);
                ganhador();
            }
        });
        btnRecomecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgEscolhaApp.setImageResource(idImage[3]);
                teste.setText("VS");
                pontuacaoApp = 0;
                pontuacaoUser = 0;
                pontosUser.setText("00");
                pontosApp.setText("00");
            }
        });
    }

    public void opcaoApp(){
        escolhaApp = random.nextInt(3);
    }

    public void ganhador(){
        if(escolhaUser == escolhaApp){
            //empate
            teste.setText("Empate!");
        }
        else if(escolhaUser == 0 && escolhaApp == 2 || escolhaUser == 2 && escolhaApp == 0){
            //pedra sempre vence / idice pedra = 0
            teste.setText("Pedra Venceu!");

            if(escolhaUser == 0){
                pontuacaoUser ++;
            }//teste quem ganhou
            if(escolhaApp == 0){
                pontuacaoApp ++;
            }
        }
        else if(escolhaUser == 0 && escolhaApp == 1 || escolhaUser == 1 && escolhaApp == 0){
            //papel sempre vence / indice papel = 1
            teste.setText("Papel Venceu!");

            if(escolhaUser == 1){
                pontuacaoUser++;
            }//teste quem ganhou
            if(escolhaApp == 1){
                pontuacaoApp++;
            }
        }
        else if(escolhaUser == 1 && escolhaApp == 2 || escolhaUser == 2 && escolhaApp == 1){
            //tesoura sempre vence
            teste.setText("Tesoura Venceu!");

            if(escolhaUser == 2){
               pontuacaoUser++;
            }//teste quem ganhou
            if(escolhaApp == 2){
                pontuacaoApp++;
            }
        }
        pontuacao();
    }
    public void pontuacao(){
        //pontuação em tela
        pontosUser.setText("0"+pontuacaoUser);
        pontosApp.setText("0"+pontuacaoApp);
    }
}