package ec.edu.tecnologicoloja.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityC extends AppCompatActivity {

    private EditText num2;
    private Button comenzar, menu;
    private int num;
    private TextView text_incorrecto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        num2 = (EditText) findViewById(R.id.textNumero1);
        comenzar = (Button) findViewById(R.id.button_startm);
        menu = (Button) findViewById(R.id.button_menu);
        text_incorrecto = (TextView) findViewById(R.id.textViewValidar);
        // Set Listeners
        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(num2.getText().length()==0){
                    text_incorrecto.setText("NO HAY VALORES...");
                }else{
                    Intent intent = new Intent(ActivityC.this, ActivityD.class);
                    intent.putExtra("dato1",Integer.parseInt(num2.getText().toString()));
                    startActivity(intent);
                }
            }
        });


        menu.setOnClickListener(startActivityAListener);

    }

    public void startActivityA() {
        Intent intent = new Intent(ActivityC.this, ActivityA.class);
        startActivity(intent);
    }


    // Listeners
    private View.OnClickListener startActivityAListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            startActivityA();
        }
    };

}
