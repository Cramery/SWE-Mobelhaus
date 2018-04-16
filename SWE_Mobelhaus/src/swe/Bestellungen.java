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
public class Bestellungen {
    @SerializedName("besteller")
    public Mobelhaus Besteller;
    @SerializedName("")
    public String bestellposition;
    @SerializedName("datum")
    public String Datum;
    @SerializedName("id")
    public int Id;
}
