package ee.edu.jpk.elina.mang2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.Attributes;

public class playerActivity extends AppCompatActivity {

  /*  EditText name, password;
    String Name, Password;
    Context ctx=this;
    String NAME=null, PASSWORD=null;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
     /*
       name = (EditText)findViewById(R.id.playerLogInName);
       password = (EditText)findViewById(R.id.playerLogInCode);
       */

    }
/*

    public void player_login(View view){
        Name = name.getText().toString();
        Password = password.getText().toString();
        Background b = new Background();
        b.execute(Name, Password);

    } */
/*
    class Background extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            String name = params[0];
            String password = params[1];
            String data = "";
            int tmp;

            try {
                URL url = new URL("");
                String urlParams = "name" + name + "&password=" + password;

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(urlParams.getBytes());
                os.flush();
                os.close();


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    return "Exception: " + e.getMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                    return "Exception: " + e.getMessage();
                }
            }
*/
 /*
        @Override
        protected void onPostExecute(String s) {
            String err=null;
            try {
                JSONObject root = new JSONObject(s);
                JSONObject user_data = root.getJSONObject("user_data");
                NAME = user_data.getString("first_name");
                PASSWORD = user_data.getString("password");

            } catch (JSONException e) {
                e.printStackTrace();
                err = "Exception: "+e.getMessage();
            }

            Intent i = new Intent(ctx, PlayerInActivity.class);
            i.putExtra("name", NAME);
            i.putExtra("password", PASSWORD);

            i.putExtra("err", err);
            startActivity(i);

        }

    }*/
}
