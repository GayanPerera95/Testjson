package com.example.testjson;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class BackgroundTask {

    Context context;
    ArrayList<Data> arrayList = new ArrayList<>();
    String json_url = "http://192.168.1.100/conn.php";

    public BackgroundTask(Context context) {
        this.context = context;

    }

    public ArrayList<Data> getList() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest( Request.Method.POST,json_url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count = 0;
                        while(count<response.length()){
                            try {
                                JSONObject jsonObject = response.getJSONObject( count );
                                Data data = new Data(jsonObject.getInt( "ID" ),jsonObject.getInt( "Value" ));
                                arrayList.add( data );
                                count++;

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }

                }, new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {

               // Toast.makeText( "Error",Toast.LENGTH_SHORT).show();
                error.printStackTrace();

            }
        } );

        MySingleton.getInstance( context ).addToRequestque( jsonArrayRequest );

        return arrayList;

    }

}
