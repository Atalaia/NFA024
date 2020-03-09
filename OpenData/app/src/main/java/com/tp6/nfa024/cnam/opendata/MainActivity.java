package com.tp6.nfa024.cnam.opendata;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

class Constantes
{
    public static final String BASE_URL = "https://opendata.paris.fr/api/records/1.0/search/";
    public static final String[] PARAMETERS={
            "dataset="
            , "rows="
            , "facet="
            , "refine"
    };
    public static final String EN_SERVICE = "en+service";
    public static final String BASIC_SERVICE = "stations-belib";
    public static final String ARGUMENT_FILTRE = "etat_station";
    public static final String APP_TAG = "NFA024_TP6";
}


public class MainActivity extends Activity {

    String source;
    TextView myTV;
    TextView myTitle;
    Button myGoButton;
    Spinner mySpinChoice;
    JSONObject data;
    JSONArray position;
    int myChoice;
    //LocationManager zeLocationManager; //pour la geo-localisation
    //JSONObject spot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.myTV = (TextView)this.findViewById(R.id.main_my_tv);
        this.myTitle = (TextView)this.findViewById(R.id.main_title_tv);
        this.myGoButton = (Button)this.findViewById(R.id.main_go_btn);

        this.myTV.setVerticalScrollBarEnabled(true);
        this.myTV.setMovementMethod(new ScrollingMovementMethod());
        this.mySpinChoice =(Spinner)this.findViewById(R.id.main_choix_spin);

        Thread loader = new Thread(){
        @Override
        public void run(){
            URL zeWebService;
                    try {
                       zeWebService = new URL(Constantes.BASE_URL
                               + "?"
                               + Constantes.PARAMETERS[0] + Constantes.BASIC_SERVICE
                               + "&"+ Constantes.PARAMETERS[1]+"20"
                               + "&"+ Constantes.PARAMETERS[2]+Constantes.ARGUMENT_FILTRE
                               + "&"+ Constantes.PARAMETERS[3]+ "."+Constantes.ARGUMENT_FILTRE
                               + "="+Constantes.EN_SERVICE
                       );
                        HttpURLConnection cnx = (HttpURLConnection)zeWebService.openConnection();
                        cnx.connect();
                        if(HttpURLConnection.HTTP_OK == cnx.getResponseCode()){
                            InputStream is = cnx.getInputStream();
                            InputStreamReader isr = new InputStreamReader(is);
                            BufferedReader reader = new BufferedReader(isr);
                            StringBuilder builder = new StringBuilder();
                            String ligne;
                            while(null != (ligne = reader.readLine())){
                             builder.append(ligne);
                            }
                            MainActivity.this.setNewSource(builder.toString());
                        }
                    }
                    catch (MalformedURLException ex){}
                    catch(IOException ex){}
         }
        };
        loader.start();
        this.myGoButton.setEnabled(false);
    }


    public void setNewSource(final String src){
        this.source = src;
        try {
            this.data = new JSONObject(src);
            this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONArray records = MainActivity.this.data.getJSONArray("records");
                    JSONObject spot = MainActivity.this.data.getJSONArray("records").getJSONObject(0);
                    MainActivity.this.myTitle.setText(spot.getJSONObject("fields").getString("adresse"));
                    MainActivity.this.myTV.setText(spot.toString());
                    MainActivity.this.position = spot.getJSONObject("fields").getJSONArray("xy");
                    MainActivity.this.myGoButton.setEnabled(true);
                    //String adresses[] = new String[records.length()];

                    ArrayList<String> zeList = new ArrayList<String>();
                    for(int i=0; i<records.length();i++){
                        //tableau de chaines de caracteres contenant les adresses
                        //adresses[i] = records.getJSONObject(i).getJSONObject("fields").getString("adresse");

                        zeList.add(records.getJSONObject(i).getJSONObject("fields").getString("adresse"));
                    }
                    //  MainActivity.this.myTitle.setText(MainActivity.this.data.getJSONArray("records").toString());
                    // MainActivity.this.myTV.setText(MainActivity.this.data.getJSONArray("records").toString());

                    ArrayAdapter<String> zeAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,zeList);
                    MainActivity.this.mySpinChoice.setAdapter(zeAdapter);
                    MainActivity.this.mySpinChoice.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> adapter, View v, int position, long arg3) {
                            MainActivity.this.myChoice = position;
                            try {
                                JSONArray records = MainActivity.this.data.getJSONArray("records");
                                JSONObject spot = MainActivity.this.data.getJSONArray("records").getJSONObject(MainActivity.this.myChoice);
                                MainActivity.this.myTitle.setText(spot.getJSONObject("fields").getString("adresse"));

                                //MainActivity.this.spot = records.getJSONObject(MainActivity.this.myChoice);
                                //String p = MainActivity.this.spot.getJSONObject("fields").getString("adresse");
                                MainActivity.this.myTV.setText(MainActivity.this.spot.toString());
                                MainActivity.this.position = MainActivity.this.spot.getJSONObject("fields").getJSONArray("xy");
                               // Location positionCourrante = MainActivity.this.zeLocationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

                                if(null != positionCourrante){
                                Location borne = new Location(p);
                                borne.setLatitude(MainActivity.this.position.getDouble(0));
                                borne.setLongitude(MainActivity.this.position.getDouble(1));
                                int distance = (int)borne.distanceTo(positionCourrante);
                                MainActivity.this.myTitle.setText(p + "\n" + distance);
                            }else {
                                MainActivity.this.myTitle.setText(p);
                            }
                        }
                            catch (JSONException e){}
                        }
                        public void onNothingSelected(AdapterView<?> arg0){}
                    });

                }
                catch (JSONException ex) {Log.i(Constantes.APP_TAG,""+ex);}
            }
            });
        }
        catch (Exception e){}
    }

    public void action(View v) throws JSONException{
        Log.i(Constantes.APP_TAG,"position ="+this.position.getDouble(0)+","+this.position.getDouble(1));

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="
                +this.position.getDouble(0)
                + "," +this.position.getDouble(1)));
        PackageManager pm = this.getPackageManager();
        if(pm.queryIntentActivities(mapIntent,0).size()>0){
            this.startActivity(mapIntent);
        }
    }
}
