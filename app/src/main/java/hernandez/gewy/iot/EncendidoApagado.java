package hernandez.gewy.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hp.bluetoothjhr.BluetoothJhr;

public class EncendidoApagado extends AppCompatActivity {
    BluetoothJhr bluetoothJhr;
    Boolean flag;
    ImageButton ap_enc, closeButt;
    TextView letter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encendido_apagado);
        flag=false;
        ap_enc=findViewById(R.id.apagarEncender);
        letter=findViewById(R.id.aCTV);
        closeButt=findViewById(R.id.closeButt);
        bluetoothJhr = new BluetoothJhr(DispositivoBluetooth.class, this);
        closeButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EncendidoApagado.this,MainActivity.class));
                finish();
            }
        });
        ap_enc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flag){
                    ap_enc.setImageResource(R.drawable.abierto);
                    letter.setText("Abierta");
                    bluetoothJhr.Tx("a");
                    flag=true;
                }else{
                    ap_enc.setImageResource(R.drawable.cerrado);
                    letter.setText("Cerrada");
                    bluetoothJhr.Tx("c");
                    flag=false;
                }
            }
        });

    }
    @Override
    public void onResume(){
        super.onResume();
        bluetoothJhr.ConectaBluetooth();
    }
    @Override
    public void onPause(){
        super.onPause();
        bluetoothJhr.CierraConexion();
    }
}