package ec.edu.tecnologicoloja.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityA extends AppCompatActivity implements View.OnClickListener{

    private Button btnJugarSolo;
    private Button btnMultijugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        // Set views
        btnJugarSolo = (Button) findViewById(R.id.btn_start_b);
        btnMultijugador = (Button) findViewById(R.id.btn_start_c);

        // Set Listeners
        btnJugarSolo.setOnClickListener(startActivityBListener);
        btnMultijugador.setOnClickListener(startActivityCListener);

    }

    public void startActivityB() {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }

    public void startActivityC() {
        Intent intent = new Intent(ActivityA.this, ActivityC.class);
        startActivity(intent);
    }
    public void finishActivityA() {
        ActivityA.this.finish();
    }
    // Listeners
    private View.OnClickListener startActivityBListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            startActivityB();
        }
    };

    private View.OnClickListener startActivityCListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            startActivityC();
        }
    };
    @Override
    public void onClick(View v) {
        if (v == btnJugarSolo) {
            startActivityB();
        } else if (v == btnMultijugador) {
            startActivityC();
        }
    }
}

