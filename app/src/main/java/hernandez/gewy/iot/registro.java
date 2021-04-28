package hernandez.gewy.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class registro extends AppCompatActivity {

    ImageButton registro,atras;
    EditText respuesta,ncont, ncont2;
    Spinner preguntas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registro= findViewById(R.id.registrar);
        respuesta = findViewById(R.id.respuesta);
        ncont= findViewById(R.id.cont);
        ncont2 = findViewById(R.id.cont2);
        preguntas= findViewById(R.id.preguntas);
        atras = findViewById(R.id.atras);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registro.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registro.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}