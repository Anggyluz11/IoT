package hernandez.gewy.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class RegistroU extends AppCompatActivity {

    ImageButton recuperar,atras;
    EditText respuesta,ncont, ncont2;
    Spinner preguntas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_u);

        recuperar= findViewById(R.id.recuperar);
        respuesta = findViewById(R.id.respuesta);
        ncont= findViewById(R.id.cont);
        ncont2 = findViewById(R.id.cont2);
        preguntas= findViewById(R.id.preguntas);
        atras = findViewById(R.id.atras);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroU.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ncont.getText().length()<8){
                    Toast.makeText(getApplicationContext(), "Contraseña corta, ingrese un minimo 8 caracteres", Toast.LENGTH_SHORT).show();
                }else {
                    if (!ncont.getText().toString().equals(ncont2.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Contraseñas inconsistentes", Toast.LENGTH_SHORT).show();
                    }else {
                        String cadena = "";
                        cadena = ncont + "";
                        try {
                            OutputStreamWriter o = new OutputStreamWriter(openFileOutput("registro.txt", Context.MODE_PRIVATE));
                            o.write(cadena);
                            o.close();
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error al guardar", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(getApplicationContext(), "Guardado exitoso", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "¡Contraseña Restablecida! ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegistroU.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }

            }
        });
    }
}