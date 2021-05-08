package hernandez.gewy.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton acceder;
    EditText contra;
    Button recu;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acceder=findViewById(R.id.accessButton);
        contra=findViewById(R.id.contra);
        recu=findViewById(R.id.recu);

        recu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistroU.class);
                startActivity(intent);
                finish();
            }
        });
        acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contra.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ingrese contraseña",Toast.LENGTH_SHORT).show();
                }
                else{
                    String pass=contra.getText().toString();
                    if(!pass.equals("cdhand30")){
                        Toast.makeText(getApplicationContext(),"Clave incorrecta",Toast.LENGTH_SHORT).show();
                    }else{
                        startActivity(new Intent(MainActivity.this,DispositivoBluetooth.class));
                        finish();
                    }
                }
            }
        });
    }
}