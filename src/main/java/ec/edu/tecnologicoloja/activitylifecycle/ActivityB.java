package ec.edu.tecnologicoloja.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    private Button btn_check, reiniciar, menu;
    private TextView tex_ingresar, tex_incorrecto;
    private EditText tex_numero;
    private int aleatorio, intentos=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // Set views
        btn_check = (Button) findViewById(R.id.comprobar);
        reiniciar = (Button) findViewById(R.id.button_jugar_otra_vez);
        menu = (Button) findViewById(R.id.button_salir);
        tex_ingresar = (TextView) findViewById(R.id.textIngresar);
        tex_numero = (EditText) findViewById(R.id.text_Numero2);
        tex_incorrecto = (TextView) findViewById(R.id.textIncorrecto1);

        reiniciar.setEnabled(false);
        aleatorio=numeroAleatorio();
        System.out.println(aleatorio);

        // Set Listeners
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tex_numero.getText().length()==0){
                    tex_incorrecto.setText("NO HAY VALORES...");
                }else{
                    int numero;
                    numero=Integer.parseInt(tex_numero.getText().toString());
                    if (numero <1 || numero>10) {
                        tex_incorrecto.setText("INGRESE NÚMERO DEL 1 AL 10");
                    }else
                        if(aleatorio!=numero){
                        intentos=intentos-1;
                        tex_incorrecto.setText("INCORRECTO...TE QUEDAN "+ intentos+ " INTENTOS");
                        tex_numero.setText("");
                    }else{
                        tex_incorrecto.setText("FELICIDADES HAS GANADO...");
                        tex_numero.setText("");
                        btn_check.setEnabled(false);
                        reiniciar.setEnabled(true);
                    }
                    if (intentos==0){
                        tex_incorrecto.setText("PERDISTE ..."+ "EL NÚMERO ERA "+aleatorio);
                        tex_numero.setText("");
                        btn_check.setEnabled(false);
                        reiniciar.setEnabled(true);
                    }
                }

            }
        });
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentos = 3;
                aleatorio = numeroAleatorio();
                System.out.println(aleatorio);
                reiniciar.setEnabled(false);
                tex_numero.setText("");
                btn_check.setEnabled(true);
                tex_incorrecto.setText("");

            }
        });
        menu.setOnClickListener(startActivityAListener);
    }
    private int numeroAleatorio(){
        return (int)(Math.random()*10+1);

    }
    public void startActivityA() {
        Intent intent = new Intent(ActivityB.this, ActivityA.class);
        startActivity(intent);
    }

    public void startActivityC() {
        Intent intent = new Intent(ActivityB.this, ActivityC.class);
        startActivity(intent);
    }

    // Listeners
    private View.OnClickListener startActivityAListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            startActivityA();
        }
    };

    private View.OnClickListener startActivityCListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            startActivityC();
        }
    };
}
