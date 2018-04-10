/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Cramery
 */
public class Mobelhaus {
    @SerializedName("id")
    public int Id;
    @SerializedName("name")
    public String Name;
    @SerializedName("moebelhausCode")
    public String Code;
    @SerializedName("ort")
    public String Ort;
    @SerializedName("plz")
    public String Plz;
    @SerializedName("kontakt")
    public Kontakt Kontakt;
    @SerializedName("strasse")
    public String Strasse;
}