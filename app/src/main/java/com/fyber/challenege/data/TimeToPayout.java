
package com.fyber.challenege.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeToPayout implements Parcelable {

    @SerializedName("amount")
    @Expose
    private int amount;
    @SerializedName("readable")
    @Expose
    private String readable;
    public final static Parcelable.Creator<TimeToPayout> CREATOR = new Creator<TimeToPayout>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TimeToPayout createFromParcel(Parcel in) {
            TimeToPayout instance = new TimeToPayout();
            instance.amount = ((int) in.readValue((int.class.getClassLoader())));
            instance.readable = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public TimeToPayout[] newArray(int size) {
            return (new TimeToPayout[size]);
        }

    };

    /**
     * @return The amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount The amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return The readable
     */
    public String getReadable() {
        return readable;
    }

    /**
     * @param readable The readable
     */
    public void setReadable(String readable) {
        this.readable = readable;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(amount);
        dest.writeValue(readable);
    }

    public int describeContents() {
        return 0;
    }

}
