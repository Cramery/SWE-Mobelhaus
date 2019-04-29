package ch.hslu.swe.JsonClasses;

import com.google.gson.annotations.SerializedName;

public class Kontakt {
    @SerializedName("email")
    public String Email;
    @SerializedName("telefon")
    public String Telefon;
}