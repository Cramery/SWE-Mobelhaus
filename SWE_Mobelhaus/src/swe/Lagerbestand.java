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
public class Lagerbestand {
    @SerializedName("anzahl")
    public int Anzahl;
    @SerializedName("id")
    public int Id;
    @SerializedName("produktTyp")
    public Produkttypen ProduktTyp;
}
