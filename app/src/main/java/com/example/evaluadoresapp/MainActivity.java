package com.example.evaluadoresapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainActivity extends AppCompatActivity {
    public static final String url = "https://evaladmin.uteq.edu.ec/ws/listadoevaluadores.php";
    RecyclerView recyclerView;
    RequestQueue solicitar_Cola;
    ArrayList<UTEQ_1_Evaluador> listaEvaluadoresUTEQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Se solicita una cola en este main activity
        solicitar_Cola = Volley.newRequestQueue(this);
        handleSSLHandshake();
        jsonObjectRequest();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    private void jsonObjectRequest(){
        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(
                Request.Method.GET,url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("listaaevaluador");
                            int resId = R.anim.layout_animation_down_to_up;
                            LayoutAnimationController miAnimation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),resId);
                            recyclerView.setLayoutAnimation(miAnimation);
                            listaEvaluadoresUTEQ = UTEQ_1_Evaluador.JsonObjectsBuild(jsonArray);
                            adaptador_evaluadores adaptador_evaluadores = new adaptador_evaluadores(MainActivity.this, listaEvaluadoresUTEQ);
                            recyclerView.setAdapter(adaptador_evaluadores);
                            adaptador_evaluadores.setOnClickListener(new View.OnClickListener() {
                                @Override
                                //FUNCIÓN ONCLICK
                                public void onClick(View v) {
                                    String ideEva = listaEvaluadoresUTEQ.get(recyclerView.getChildAdapterPosition(v)).getIdEv();
                                    Intent intent = new Intent(MainActivity.this, actListaEvaluar1.class);
                                    Bundle mostrar = new Bundle();
                                    mostrar.putString("vIdentificacionEva", ideEva);
                                    intent.putExtras(mostrar);
                                    startActivity(intent);
                                }
                            });
                            System.out.println("Data: "+listaEvaluadoresUTEQ);
                        }
                        catch (JSONException ex){System.out.println("Error: "+ex.toString());}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {System.out.println("Error: "+error.toString());}
        }
        );
        solicitar_Cola.add(jsonArrayRequest);
    }
    @SuppressLint("TrulyRandom")
    public static void handleSSLHandshake() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }};
            //CERTIFICADO SSL
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
        } catch (Exception ignored) { }
    }
}