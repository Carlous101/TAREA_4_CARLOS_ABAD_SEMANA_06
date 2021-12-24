package com.example.evaluadoresapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UTEQ_1_Evaluador {
    private String nombre;
    private String area;
    private String idEv;
    private String calificacion;
    private String urlImg1;
    private String urlImg2;

    public UTEQ_1_Evaluador(JSONObject a)  { //String nom, String are, String ide, String img1, String img2
        try {
            nombre = a.getString("nombres").toString() ;
            area = a.getString("area").toString() ;
            idEv = a.getString("idevaluador").toString() ;
            urlImg1 = a.getString("imgJPG").toString() ;
            urlImg2 = a.getString("imgjpg").toString() ;
        } catch (JSONException e) {
            System.out.println("Error: " + e.toString());
        }
    }


   public static ArrayList<UTEQ_1_Evaluador> JsonObjectsBuild(JSONArray datos) throws JSONException {
       ArrayList<UTEQ_1_Evaluador> evaluadores = new ArrayList<>();

       for (int i = 0; i < datos.length() ; i++) {
           evaluadores.add(new UTEQ_1_Evaluador(datos.getJSONObject(i)));
       }
       return evaluadores;
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIdEv() {
        return idEv;
    }

    public void setIdEv(String idEv) {
        this.idEv = idEv;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getUrlImg1() {
        return urlImg1;
    }

    public void setUrlImg1(String urlImg1) {
        this.urlImg1 = urlImg1;
    }

    public String getUrlImg2() {
        return urlImg2;
    }

    public void setUrlImg2(String urlImg2) {
        this.urlImg2 = urlImg2;
    }
}
