package hernandez.gewy.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothA2dp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.hp.bluetoothjhr.BluetoothJhr;

public class DispositivoBluetooth extends AppCompatActivity {
    BluetoothJhr bluetoothJhr;
    ListView disp;
    ImageButton atras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispositivo_bluetooth);
        disp=findViewById(R.id.listaDisp);
        atras=findViewById(R.id.closeButt);
        bluetoothJhr = new BluetoothJhr(this, disp);
        bluetoothJhr.EncenderBluetooth();

        disp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                bluetoothJhr.Disp_Seleccionado(view, i, EncendidoApagado.class);
                finish();
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DispositivoBluetooth.this,MainActivity.class));
                finish();
            }
        });
    }
}