/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe.JsonClasses;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

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
    public Date datum;
    @SerializedName("id")
    public int Id;
    @SerializedName("unvollstaendig")
    public Boolean Unvollstaendig;
}
