package hernandez.gewy.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton desbloquear;
    EditText contraseña;
    Button recu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        desbloquear= findViewById(R.id.desbloquear);
        contraseña = findViewById(R.id.contraseña);
        recu = findViewById(R.id.recup);

        desbloquear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EncendidoApagado.class);
                startActivity(intent);
                finish();
            }
        });
        recu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistroU.class);
                startActivity(intent);
                finish();
            }
        });
    }
}