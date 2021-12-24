package com.example.evaluadoresapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UTEQ_2_Evaluar {
    private String idevaluado;
    private String nombreevaluado;
    private String genero;
    private String situacion;
    private String cargo;
    private String fechainicio;
    private String fechafin;
    private String Urlimg1;
    private String Urlimg2;

    public String getIdevaluado() {
        return idevaluado;
    }

    public void setIdevaluado(String idevaluado) {
        this.idevaluado = idevaluado;
    }

    public String getNombreevaluado() {
        return nombreevaluado;
    }

    public void setNombreevaluado(String nombreevaluado) {
        this.nombreevaluado = nombreevaluado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getUrlimg1() {
        return Urlimg1;
    }

    public void setUrlimg1(String urlimg1) {
        Urlimg1 = urlimg1;
    }

    public String getUrlimg2() {
        return Urlimg2;
    }

    public void setUrlimg2(String urlimg2) {
        Urlimg2 = urlimg2;
    }
    public static ArrayList<UTEQ_2_Evaluar> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<UTEQ_2_Evaluar> evaluados = new ArrayList<>();

        for (int i = 0; i < datos.length() ; i++) {
            evaluados.add(new UTEQ_2_Evaluar(datos.getJSONObject(i)));
        }
        return evaluados;
    }

    public UTEQ_2_Evaluar(JSONObject a)  { //String nom, String are, String ide, String img1, String img2
        try {
            nombreevaluado = a.getString("Nombres").toString();
            idevaluado = a.getString("idevaluado").toString();
            genero = a.getString("genero").toString();
            situacion = a.getString("situacion").toString();
            cargo = a.getString("cargo").toString();
            fechainicio = a.getString("fechainicio").toString();
            fechafin = a.getString("fechafin").toString();
            Urlimg1 = a.getString("imgJPG").toString();
            Urlimg2 = a.getString("imgjpg").toString();
        } catch (JSONException e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
