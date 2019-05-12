package sanchezartega.facci.rencaronline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

import sanchezartega.facci.rencaronline.Slide.WelcomeActivity;


public class SplashCreen extends AppCompatActivity {
    private final int DURANTION_SPLAIN=3000;// insertamos el tiempo de tardara la ejecucion
    private ProgressBar Lineal;
    private Timer timer;
    private ProgressBar progressBar;
    private int i = 0;
    private View logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashcreen);
        ;
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hacemos inicie en pantalla completa
        logo =(View)findViewById(R.id.image2);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        final long intervalo = 50;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (i < 100){
                    progressBar.setProgress(i);
                    i++;
                }else{
                    timer.cancel();
                    Intent intent = new Intent(SplashCreen.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },0,intervalo);
        Animation sysnic = AnimationUtils.loadAnimation(SplashCreen.this, R.anim.animacion);
logo.startAnimation(sysnic);
    }
}
