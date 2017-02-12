
package com.fyber.challenege.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class OffersResponse implements Parcelable {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("pages")
    @Expose
    private int pages;
    @SerializedName("information")
    @Expose
    private Information information;
    @SerializedName("offers")
    @Expose
    private List<Offer> offers = new ArrayList<Offer>();
    public final static Parcelable.Creator<OffersResponse> CREATOR = new Creator<OffersResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OffersResponse createFromParcel(Parcel in) {
            OffersResponse instance = new OffersResponse();
            instance.code = ((String) in.readValue((String.class.getClassLoader())));
            instance.message = ((String) in.readValue((String.class.getClassLoader())));
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            instance.pages = ((int) in.readValue((int.class.getClassLoader())));
            instance.information = ((Information) in.readValue((Information.class.getClassLoader())));
            in.readList(instance.offers, (com.fyber.challenege.data.Offer.class.getClassLoader()));
            return instance;
        }

        public OffersResponse[] newArray(int size) {
            return (new OffersResponse[size]);
        }

    };

    /**
     * @return The code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return The pages
     */
    public int getPages() {
        return pages;
    }

    /**
     * @param pages The pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * @return The information
     */
    public Information getInformation() {
        return information;
    }

    /**
     * @param information The information
     */
    public void setInformation(Information information) {
        this.information = information;
    }

    /**
     * @return The offers
     */
    public List<Offer> getOffers() {
        return offers;
    }

    /**
     * @param offers The offers
     */
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(code);
        dest.writeValue(message);
        dest.writeValue(count);
        dest.writeValue(pages);
        dest.writeValue(information);
        dest.writeList(offers);
    }

    public int describeContents() {
        return 0;
    }

}
