
package com.fyber.challenege.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnail implements Parcelable {

    @SerializedName("lowres")
    @Expose
    private String lowres;
    @SerializedName("hires")
    @Expose
    private String hires;
    public final static Parcelable.Creator<Thumbnail> CREATOR = new Creator<Thumbnail>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Thumbnail createFromParcel(Parcel in) {
            Thumbnail instance = new Thumbnail();
            instance.lowres = ((String) in.readValue((String.class.getClassLoader())));
            instance.hires = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Thumbnail[] newArray(int size) {
            return (new Thumbnail[size]);
        }

    };

    /**
     * @return The lowres
     */
    public String getLowres() {
        return lowres;
    }

    /**
     * @param lowres The lowres
     */
    public void setLowres(String lowres) {
        this.lowres = lowres;
    }

    /**
     * @return The hires
     */
    public String getHires() {
        return hires;
    }

    /**
     * @param hires The hires
     */
    public void setHires(String hires) {
        this.hires = hires;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lowres);
        dest.writeValue(hires);
    }

    public int describeContents() {
        return 0;
    }

}
