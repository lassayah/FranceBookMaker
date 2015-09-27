package projet.lassayah.com.francebookmaker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import cz.msebera.android.httpclient.Header;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private AlertDialog alert11;
    private View v;
    private Button loginButton;
    private Button cheatButton;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_main, container, false);
        // 1. Instantiate an AlertDialog.Builder with its constructor
        loginButton = (Button)v.findViewById(R.id.loginButton);
        cheatButton = (Button)v.findViewById(R.id.cheatButton);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Veuillez entrer à nouveau votre mot de passe")
                .setTitle("Mot de passe incorrect")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alert11 = builder.create();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestParams params = new RequestParams();
                params.add("login", "Laurene");
                params.add("password", "moqh17e");
                AsyncHttpClient client = new AsyncHttpClient();
                client.get("http://assayah.com/Brazil/webservices/login.php", params, new JsonHttpResponseHandler() {
                    // When the response returned by REST has Http response code '200'
                    @Override
                    public void onSuccess(int i, Header[] headers, JSONObject response) {
                        // If the response is JSONObject instead of expected JSONArray
                        String result = null;
                        try {
                            result = (String) response.get("result");
                            if (result.equals("true")) {
                                SharedPreferences prefs = getActivity().getSharedPreferences("com.worldcup.brazilbookmaker", Context.MODE_PRIVATE);
                                String login = ((EditText) v.findViewById(R.id.loginEdit)).getText().toString();
                                prefs.edit().putString("login", login).commit();
                                System.out.println("bravo!");
                                Intent intent = new Intent(getActivity().getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                                //Intent intent = new Intent(getActivity().getApplicationContext(), MainActivityFragment.class);
                                //startActivity(intent);
                            } else {

                                alert11.show();
                                EditText passwordEdit = (EditText) v.findViewById(R.id.passwordEdit);
                                passwordEdit.setText("");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    // cas de réponse du serveur sans erreur
                    @Override
                    public void onSuccess(int i, Header[] headers, JSONArray response) {
                        try {
                            JSONObject jsonObject;
                            // récupération des valeurs des champs du json
                            for (int j = 0; j < response.length(); j++) {
                                jsonObject = response.getJSONObject(j);
                                String result = (String) jsonObject.get("result");
                                if (result.equals("true")) {
                                    SharedPreferences prefs = getActivity().getSharedPreferences("com.worldcup.brazilbookmaker", Context.MODE_PRIVATE);
                                    String login = ((EditText) v.findViewById(R.id.loginEdit)).getText().toString();
                                    prefs.edit().putString("login", login).commit();
                                    System.out.println("bravo!");
                                    Intent intent = new Intent(getActivity().getApplicationContext(), HomeActivity.class);
                                    startActivity(intent);
                                    //Intent intent = new Intent(getActivity().getApplicationContext(), MainActivityFragment.class);
                                    //startActivity(intent);
                                } else {

                                    alert11.show();
                                    EditText passwordEdit = (EditText) v.findViewById(R.id.passwordEdit);
                                    passwordEdit.setText("");
                                }
                            }


                        } catch (Exception e) {
                            // TODO Auto-generated catch block

                            e.printStackTrace();

                        }
                    }


                });
            }
        });

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }



}