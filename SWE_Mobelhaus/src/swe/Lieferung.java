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
public class Lieferung {
    @SerializedName("bemerkung")
    public String Bemerkung;
    @SerializedName("bestellung")
    public Bestellungen Bestellung;
    @SerializedName("lieferungPositionListe")
    public BestellPosition[] LieferungPositionListe;
    @SerializedName("datum")
    public String datum;
    @SerializedName("id")
    public int Id;
    @SerializedName("unvollstaendig")
    public Boolean Unvollstaendig;
}
