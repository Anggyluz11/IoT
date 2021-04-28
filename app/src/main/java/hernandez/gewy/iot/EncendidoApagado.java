package hernandez.gewy.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class EncendidoApagado extends AppCompatActivity {

    ImageButton candado, atras;
    TextView statuscan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encendido_apagado);
        candado= findViewById(R.id.candado);
        statuscan = findViewById(R.id.statuscandado);
        atras = findViewById(R.id.atras);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EncendidoApagado.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        candado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(statuscan.getText().toString()=="Cerrado"){
                    statuscan.setText("Abierto");
                }else{
                    statuscan.setText("Cerrado");
                }
            }
        });
    }
}