/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe.JsonClasses;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Cramery
 */
public class Adresse {
    @SerializedName("ort")
    public String Ort;
    @SerializedName("plz")
    public String Plz;
    @SerializedName("strasse")
    public String Strasse;
}
