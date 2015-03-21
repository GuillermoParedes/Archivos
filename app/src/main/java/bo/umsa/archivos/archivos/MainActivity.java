package bo.umsa.archivos.archivos;

import android.content.res.AssetManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void paraListar(View view){
        try {
            AssetManager p = getAssets();
            InputStream lector = p.open("archivo.txt");
            String linea;
            int largo = 0;
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            byte[] butes = new byte[1024];
            while( (largo = lector.read(butes)) > 0){
                bs.write(butes,0,largo);
            }
            lector.close();
            linea = new String(bs.toByteArray(),"UTF-8");
            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setText(linea);
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}
