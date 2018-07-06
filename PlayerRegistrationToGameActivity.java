package ee.edu.jpk.elina.mang2;


import android.content.DialogInterface;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;


public class PlayerRegistrationToGameActivity extends AppCompatActivity {

    Button button;

    EditText etFirst_player_name, etFirst_player_code;
    EditText etSecond_player_name, etSecond_player_code;
    EditText etThird_player_name, etThird_player_code;
    EditText etFourth_player_name, etFourth_player_code;


    // WampServer32 kasutades, tuleb ühenduse ip-adressiks määrata oma füüsilise arvuti ip-aadress
    //String server_url = "http://172.18.230.241/updateinfotest.php";

    String server_url = "http://192.168.1.80/update_info_p.php";
    // String server_url = "http://192.168.5.71/care/updateinfotest.php";


    AlertDialog.Builder builder;

    Button questions_reg_open_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_registration_to_game);

        questions_reg_open_button = (Button) findViewById(R.id.questions_reg_open_button);
        questions_reg_open_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openquestionsManagerActivity();
            }
        });


        button = (Button) findViewById(R.id.reg_user);

        final List<TextInputEditText> playerNamesTextViews = getPlayerNamesTextViews();
        final List<TextInputEditText> playerCodesTextViews = getPlayerCodesTextViews();

        builder = new AlertDialog.Builder(PlayerRegistrationToGameActivity.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        builder.setTitle("Server Response");
                        builder.setMessage("Vastus: " + response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                for (TextInputEditText playerName : playerNamesTextViews) {
                                    playerName.setText("");
                                }

                                for (TextInputEditText playerCode : playerCodesTextViews) {
                                    playerCode.setText("");
                                }
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    }
                }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PlayerRegistrationToGameActivity.this, "Error...", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();

                        for(int i = 0; i < 4; i++) {
                            params.put("user_name" + (i + 1), playerNamesTextViews.get(i).getText().toString());
                            params.put("user_pass" + (i + 1), playerCodesTextViews.get(i).getText().toString());
                        }

                        return params;
                    }
                };

                Mysingleton.getInstance(PlayerRegistrationToGameActivity.this).addTorequestque(stringRequest);

            }
        });

    }

    @NonNull
    private List<TextInputEditText> getPlayerCodesTextViews() {
        return asList((TextInputEditText) findViewById(R.id.first_player_code), (TextInputEditText) findViewById(R.id.second_player_code), (TextInputEditText) findViewById(R.id.third_player_code), (TextInputEditText) findViewById(R.id.fourth_player_code));
    }

    @NonNull
    private List<TextInputEditText> getPlayerNamesTextViews() {
        return asList((TextInputEditText) findViewById(R.id.first_player_name), (TextInputEditText) findViewById(R.id.second_player_name), (TextInputEditText) findViewById(R.id.third_player_name), (TextInputEditText) findViewById(R.id.fourth_player_name));
    }

    public void openquestionsManagerActivity() {
        Intent intent = new Intent(this, QuestionsManagerActivity.class);
        startActivity(intent);
    }


}