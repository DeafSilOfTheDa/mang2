package ee.edu.jpk.elina.mang2;



import android.content.Context;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import android.widget.LinearLayout;
import android.widget.PopupWindow;

import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ee.edu.jpk.elina.mang2.models.Question;

import static java.util.Arrays.asList;


public class QuestionsManagerActivity extends AppCompatActivity {

    private Button mQ1Button;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private LinearLayout linearLayout;
/////////////////////////////////////////////////
    HttpResponse httpResponse;
    TextView Q1textView;
    JSONObject jsonObject = null;
    String StringHolder="";
   // ProgressBar progressBar;
    Button buttonQ1;


    // Adding HTTP Server URL to string variable.
    // WampServer32 kasutades, tuleb ühenduse ip-adressiks määrata oma füüsilise arvuti ip-aadress
    String HttpURL = "192.168.80.1/getQuestions.php";

    //////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_manager);
        //////////////////////////////////////////

        // Assigning ID's to button, textView and progressbar.
        Q1textView = (TextView)findViewById(R.id.textQ1);
      //  progressBar (ProgressBar)findViewById(R.id.progressBar);

      //// Intent intent = new Intent(questionsManagerActivity.this,popupWindowsLayoutActivity.class);
      //// intent.putExtra("TheQuestion", "1");
      //// startActivity(intent);

        //////////////////////////////////////////
        linearLayout = (LinearLayout) findViewById(R.id.linear);

        List<Integer> questionButtonIds = asList(R.id.buttonQ1, R.id.buttonQ2, R.id.buttonQ3, R.id.buttonQ4, R.id.buttonQ5, R.id.buttonQ6, R.id.buttonQ7, R.id.buttonQ8, R.id.buttonQ9, R.id.buttonQ10);
        for (Integer id : questionButtonIds) {

            ((Button) findViewById(id)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /////////////////////////
                    //Showing progress bar on button click
                    //progressBar.setVisibility(View.VISIBLE);

                    //Calling GetDataFromServerIntoTextView method to Set Json MySql data into TextView.
                   // new GetDataFromServerIntoTextView (QuestionsManagerActivity.this).execute();



                    /////////////////////////
                    layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                    ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.activity_popup_windows_layout, null);

                    //popupWindow = new PopupWindow(container,500,500,true);

                    popupWindow = new PopupWindow(container, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                    popupWindow.showAtLocation(linearLayout, Gravity.CENTER,0,0);

                    Button closeButton = (Button) container.findViewById(R.id.popup_close_button);

                    closeButton.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            popupWindow.dismiss();

                            return true;
                        }
                    });
                }

            });
        }

    }

    ///////////////////////
            // Declaring GetDataFromServerIntoTextView method with AsyncTask.
/*
            public class GetDataFromServerIntoTextView extends AsyncTask<Void, Void, Void>{

                // Declaring CONTEXT
                public Context context;

                public GetDataFromServerIntoTextView(Context context)
                {
                    this.context = context;
                }
                @Override
                protected void onPreExecute(){
                    super.onPreExecute();
                }

                @Override
                protected Void doInBackground(Void...arg0){

                    HttpClient httpClient = new DefaultHttpClient();
                    // Adding HttpURL to my HttpPost oject.
                  // WampServer32 kasutades, tuleb ühenduse ip-adressiks määrata oma füüsilise arvuti ip-aadress
                    HttpPost httpPost = new HttpPost("192.168.1.80/getQuestions.php");

                    try{
                        httpResponse = httpClient.execute(httpPost);

                        StringHolder = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

                    } catch (ClientProtocolException e){
                        e.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    try{
                        // Passing string holder variable to JSONArray
                        JSONArray jsonArray = new JSONArray(StringHolder);
                        jsonObject = jsonObject.getJSONObject("TheQuestion");
                    } catch (JSONException e){
                        e.printStackTrace();
                    }catch (Exception e){
                        //TODO Auto-generate catch block
                        e.printStackTrace();
                    }return null;

                }
                protected void onPostExecute (Void result){
                    try{
                        //adding JSOn string to textview after done loading.
                        mQ1Button.setText(jsonObject.getString("TheQuestion"));
                    }catch (JSONException e){
                        //TODO Auto-generated catch block
                        e.printStackTrace();
                 

                    }
                    //Hidding progress bar after done download TextView.
                //    progressBar.setVisibility(View.GONE);
                }

            }

*/




        /////////////test ühendamiseks//////////


}


