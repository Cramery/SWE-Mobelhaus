/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.swe.JsonClasses;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Cramery
 */
public class Produkttypen {
    @SerializedName("ablageTablar")
    public AblageTablar AblageTablar;
    @SerializedName("beschreibung")
    public String Beschreibung;
    @SerializedName("id")
    public int Id;
    @SerializedName("maximalerBestand")
    public int MaxBestand;
    @SerializedName("minimalerBestand")
    public int MinBestand;
    @SerializedName("name")
    public String Name;
    @SerializedName("preis")
    public double Preis;
    @SerializedName("typCode")
    public String TypCode;
}
