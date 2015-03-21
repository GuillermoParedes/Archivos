package bo.umsa.archivos.archivos;

import android.content.res.AssetManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void paraListar(View view){
        try {
            /*AssetManager p = getAssets();
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
            tv.setText(linea);*/
            InputStream fraw = getResources().openRawResource(R.raw.archivo);

            BufferedReader brin =  new BufferedReader(new InputStreamReader(fraw));



            String linea = brin.readLine();
            String linea2 = brin.readLine();
            String linea3 = brin.readLine();
            fraw.close();
            //linea = new String(bs.toByteArray(),"UTF-8");
            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setText(linea +"/n" +linea2 +"/n" +linea3  );

        }
        catch (IOException e){
            e.printStackTrace();
            Log.e("Ficheros", "Error al leer fichero desde recurso raw");
        }


    }
}
