package ec.edu.tecnologicoloja.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityD extends AppCompatActivity {

    private EditText ingresar_3;
    private TextView tex_incorrecto;
    private Button comprobar, volver_jugar;
    private int intentos =3;
    public int num1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

        ingresar_3 = (EditText) findViewById(R.id.text_Numero_3);
        tex_incorrecto = (TextView) findViewById(R.id.textView2);
        comprobar = (Button) findViewById(R.id.button_check2);
        volver_jugar = (Button) findViewById(R.id.button_volver_jugar);
        recibe();


        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num = Integer.parseInt(ingresar_3.getText().toString());
                if (num1 == num) {
                    ingresar_3.setText("");
                    tex_incorrecto.setText("FELICIDADES HAS GANADO...");
                    comprobar.setEnabled(false);
                } else {
                    intentos = intentos - 1;
                    tex_incorrecto.setText("INCORRECTO...TE QUEDAN " + intentos + " INTENTOS");
                    ingresar_3.setText("");
                }
                if (intentos == 0) {
                    ingresar_3.setText("");
                    comprobar.setEnabled(false);
                }

            }
        });
        volver_jugar.setOnClickListener(startActivityCListener);

    }
    private void recibe(){
        Bundle extras = getIntent().getExtras();
        int d1 = extras.getInt("dato1");
        num1= d1;
    }
        public void startActivityC () {
            Intent intent = new Intent(ActivityD.this, ActivityC.class);
            startActivity(intent);
        }

        // Listeners

        private View.OnClickListener startActivityCListener = new View.OnClickListener() {
            public void onClick(View v) {
                // do something when the button is clicked
                startActivityC();
            }
        };
    }

