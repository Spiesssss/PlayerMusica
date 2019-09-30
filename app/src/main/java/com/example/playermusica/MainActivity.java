package com.example.playermusica;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

//Classe que representa a interface gráfica do programa, no caso essa tela
public class MainActivity extends AppCompatActivity {

    //Campos que representam o nosso vetor de músicas, a música atual
    //e o MediaPlayer
    private ArrayList<Musica> playlist;
    private int musicaAtual;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializa a musicaAtual como zero
        musicaAtual =0;

        //Inicializa o ArrayList
        playlist = new ArrayList<Musica>();

        //método que faz a adição das músicas na playlist.
        inicializaPlaylist();

        //Isso aqui já está dentro do onCreate
        //Inicializa a variável mediaPlayer
        mediaPlayer = MediaPlayer.create(this,R.raw.musica1);
    }

    //Método que inicializa a nossa playlist de músicas.
    public void inicializaPlaylist() {
        //Criando um novo objeto do tipo Musica com as informações necessárias.
        Musica musica = new Musica("Hit Em Up (Dirty)",
                "2 Pac","musica1");
        //Usamos o método "add" da classe ArrayList para adicionar na playlist.
        playlist.add(musica);

        //adicionando a segunda música
        musica = new Musica("Who shot Ya",
                "Notorious Big","musica2");
        playlist.add(musica);

        //Adicionando a terceira música ...
        musica = new Musica("Boate Azul",
                "Milionário e José Rico","musica3");
        playlist.add(musica);

        //Adicionando a quarta música
        musica = new Musica("Sanfona Mix original(2010)",
                "Desconhecido","musica4");
        playlist.add(musica);

        //adicionando a quinta música
        musica = new Musica("Deixa em Off",
                "Turma do pagode","musica5");
        playlist.add(musica);
    }

    //Método que manda tocar uma música ao pressionar "Play"
    public void play(View view){
        tocarMusica();
    }

    //Método que manda tocar música e atualiza as informações da interface
    public void tocarMusica(){
        //Pega os componentes textView que mostram o nome da música e artista
        TextView tv_mostraNome = findViewById(R.id.tv_nomeMusica);
        TextView tv_mostraArtista = findViewById(R.id.tv_mostraArtista);

        //Cria uma música temporária que representa a música que está sendo tocada
        Musica estaMusica = playlist.get(musicaAtual);
        //Coloca o texto na interface da música que está tocando
        tv_mostraArtista.setText(estaMusica.getArtista());
        tv_mostraNome.setText(estaMusica.getNome());

        //AQUI IREMOS COMEÇAR COM AS AÇÕES DE MANIPULAÇÃO DE MÍDIA

        //Criar uma variável local para armazenar o id do recurso mp3
        int idArquivoMusica = getResources()
                .getIdentifier(estaMusica.getNomeArquivo(),
                        "raw",getPackageName());

        //Utiliza a variável do tipo MediaPlayer responsável por tocar o mp3
        //Essa variável recebe como parâmetro o idArquivoMusica que acabamos
        //de gerar com o nome do arquivo da música.
        mediaPlayer = MediaPlayer
                .create(this,idArquivoMusica);

        //Agora basta mandar tocar
        mediaPlayer.start();

    }

    //Método que passa para frente
    public void passarFrente(View view){
        //parar a música antes de tocar a próxima
        mediaPlayer.stop();
        if(musicaAtual==playlist.size()-1){
            musicaAtual=0;
            tocarMusica();
        }else {
            musicaAtual++;
            tocarMusica();
        }
    }

    //Método que passa para trás
    public void passarTras(View view){
        //parar a música antes de voltar para a anterior
        mediaPlayer.stop();
        if(musicaAtual==0){
            musicaAtual=4;
            tocarMusica();
        }else {
            musicaAtual--;
            tocarMusica();
        }
    }

}
