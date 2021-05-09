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

import com.an.biometric.BiometricCallback;
import com.an.biometric.BiometricManager;

public class MainActivity extends AppCompatActivity implements BiometricCallback {
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
                        new BiometricManager.BiometricBuilder(MainActivity.this)
                                .setTitle("Desbloqueo por huella")
                                .setSubtitle("")
                                .setDescription("Escaneé su huella")
                                .setNegativeButtonText("cancel")
                                .build()
                                .authenticate(MainActivity.this);
                    }
                }
            }
        });
    }

    @Override
    public void onSdkVersionNotSupported() {

    }

    @Override
    public void onBiometricAuthenticationNotSupported() {

    }

    @Override
    public void onBiometricAuthenticationNotAvailable() {

    }

    @Override
    public void onBiometricAuthenticationPermissionNotGranted() {

    }

    @Override
    public void onBiometricAuthenticationInternalError(String error) {

    }

    @Override
    public void onAuthenticationFailed() {

    }

    @Override
    public void onAuthenticationCancelled() {

    }

    @Override
    public void onAuthenticationSuccessful() {
        startActivity(new Intent(MainActivity.this,DispositivoBluetooth.class));
        finish();
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {

    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {

    }
}