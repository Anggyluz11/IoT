package hernandez.gewy.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothA2dp;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hp.bluetoothjhr.BluetoothJhr;

public class DispositivoBluetooth extends AppCompatActivity {
    BluetoothJhr bluetoothJhr;
    ListView disp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispositivo_bluetooth);
        disp=findViewById(R.id.listaDisp);
        bluetoothJhr = new BluetoothJhr(this, disp);
        bluetoothJhr.EncenderBluetooth();
        disp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                bluetoothJhr.Disp_Seleccionado(view, i, EncendidoApagado.class);
                finish();
            }
        });
    }
}