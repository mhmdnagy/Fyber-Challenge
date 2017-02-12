
package com.fyber.challenege.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Offer implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("offer_id")
    @Expose
    private int offerId;
    @SerializedName("teaser")
    @Expose
    private String teaser;
    @SerializedName("required_actions")
    @Expose
    private String requiredActions;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("offer_types")
    @Expose
    private List<OfferType> offerTypes = new ArrayList<OfferType>();
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("payout")
    @Expose
    private int payout;
    @SerializedName("time_to_payout")
    @Expose
    private TimeToPayout timeToPayout;
    public final static Parcelable.Creator<Offer> CREATOR = new Creator<Offer>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Offer createFromParcel(Parcel in) {
            Offer instance = new Offer();
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.offerId = ((int) in.readValue((int.class.getClassLoader())));
            instance.teaser = ((String) in.readValue((String.class.getClassLoader())));
            instance.requiredActions = ((String) in.readValue((String.class.getClassLoader())));
            instance.link = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.offerTypes, (com.fyber.challenege.data.OfferType.class.getClassLoader()));
            instance.thumbnail = ((Thumbnail) in.readValue((Thumbnail.class.getClassLoader())));
            instance.payout = ((int) in.readValue((int.class.getClassLoader())));
            instance.timeToPayout = ((TimeToPayout) in.readValue((TimeToPayout.class.getClassLoader())));
            return instance;
        }

        public Offer[] newArray(int size) {
            return (new Offer[size]);
        }

    };

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The offerId
     */
    public int getOfferId() {
        return offerId;
    }

    /**
     * @param offerId The offer_id
     */
    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    /**
     * @return The teaser
     */
    public String getTeaser() {
        return teaser;
    }

    /**
     * @param teaser The teaser
     */
    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    /**
     * @return The requiredActions
     */
    public String getRequiredActions() {
        return requiredActions;
    }

    /**
     * @param requiredActions The required_actions
     */
    public void setRequiredActions(String requiredActions) {
        this.requiredActions = requiredActions;
    }

    /**
     * @return The link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return The offerTypes
     */
    public List<OfferType> getOfferTypes() {
        return offerTypes;
    }

    /**
     * @param offerTypes The offer_types
     */
    public void setOfferTypes(List<OfferType> offerTypes) {
        this.offerTypes = offerTypes;
    }

    /**
     * @return The thumbnail
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail The thumbnail
     */
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return The payout
     */
    public int getPayout() {
        return payout;
    }

    /**
     * @param payout The payout
     */
    public void setPayout(int payout) {
        this.payout = payout;
    }

    /**
     * @return The timeToPayout
     */
    public TimeToPayout getTimeToPayout() {
        return timeToPayout;
    }

    /**
     * @param timeToPayout The time_to_payout
     */
    public void setTimeToPayout(TimeToPayout timeToPayout) {
        this.timeToPayout = timeToPayout;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(offerId);
        dest.writeValue(teaser);
        dest.writeValue(requiredActions);
        dest.writeValue(link);
        dest.writeList(offerTypes);
        dest.writeValue(thumbnail);
        dest.writeValue(payout);
        dest.writeValue(timeToPayout);
    }

    public int describeContents() {
        return 0;
    }

}
