
package com.fyber.challenege.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OfferType implements Parcelable {

    @SerializedName("offer_type_id")
    @Expose
    private int offerTypeId;
    @SerializedName("readable")
    @Expose
    private String readable;
    public final static Parcelable.Creator<OfferType> CREATOR = new Creator<OfferType>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OfferType createFromParcel(Parcel in) {
            OfferType instance = new OfferType();
            instance.offerTypeId = ((int) in.readValue((int.class.getClassLoader())));
            instance.readable = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public OfferType[] newArray(int size) {
            return (new OfferType[size]);
        }

    };

    /**
     * @return The offerTypeId
     */
    public int getOfferTypeId() {
        return offerTypeId;
    }

    /**
     * @param offerTypeId The offer_type_id
     */
    public void setOfferTypeId(int offerTypeId) {
        this.offerTypeId = offerTypeId;
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
        dest.writeValue(offerTypeId);
        dest.writeValue(readable);
    }

    public int describeContents() {
        return 0;
    }

}
