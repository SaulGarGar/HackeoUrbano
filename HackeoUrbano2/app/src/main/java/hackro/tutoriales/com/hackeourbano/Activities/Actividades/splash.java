package hackro.tutoriales.com.hackeourbano.Activities.Actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hackro.tutoriales.com.hackeourbano.R;

public class splash extends AppCompatActivity {

    private long ms=0;
    private long splashTime=3000;
    private boolean splashActive = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //---------------------------------------------//
        Thread mythread = new Thread() {//Creamos un hilo
            public void run() {
                try {
                    while (splashActive && ms < splashTime) {//Condicional,mientras los ms sea menor al tiempo de duracion
                        ms=ms+1000;//Se incrementara de segundo en segundo 1..2..3..4..5 etc
                        sleep(1000);
                    }
                } catch(Exception e) {}
                finally {//Cuando se termine el tiempo duracion
                    Intent intent = new Intent(splash.this, Main2Activity.class);//Mandaremos al usuario a un nuevo Activity  Intent(ActivityActual.this, NuevoActivity.class);
                    startActivity(intent);
                }
            }
        };
        mythread.start();
    }
    }
}
