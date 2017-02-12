
package com.fyber.challenege.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Information implements Parcelable {

    @SerializedName("app_name")
    @Expose
    private String appName;
    @SerializedName("appid")
    @Expose
    private int appid;
    @SerializedName("virtual_currency")
    @Expose
    private String virtualCurrency;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("support_url")
    @Expose
    private String supportUrl;
    public final static Parcelable.Creator<Information> CREATOR = new Creator<Information>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Information createFromParcel(Parcel in) {
            Information instance = new Information();
            instance.appName = ((String) in.readValue((String.class.getClassLoader())));
            instance.appid = ((int) in.readValue((int.class.getClassLoader())));
            instance.virtualCurrency = ((String) in.readValue((String.class.getClassLoader())));
            instance.country = ((String) in.readValue((String.class.getClassLoader())));
            instance.language = ((String) in.readValue((String.class.getClassLoader())));
            instance.supportUrl = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Information[] newArray(int size) {
            return (new Information[size]);
        }

    };

    /**
     * @return The appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * @param appName The app_name
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * @return The appid
     */
    public int getAppid() {
        return appid;
    }

    /**
     * @param appid The appid
     */
    public void setAppid(int appid) {
        this.appid = appid;
    }

    /**
     * @return The virtualCurrency
     */
    public String getVirtualCurrency() {
        return virtualCurrency;
    }

    /**
     * @param virtualCurrency The virtual_currency
     */
    public void setVirtualCurrency(String virtualCurrency) {
        this.virtualCurrency = virtualCurrency;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return The supportUrl
     */
    public String getSupportUrl() {
        return supportUrl;
    }

    /**
     * @param supportUrl The support_url
     */
    public void setSupportUrl(String supportUrl) {
        this.supportUrl = supportUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(appName);
        dest.writeValue(appid);
        dest.writeValue(virtualCurrency);
        dest.writeValue(country);
        dest.writeValue(language);
        dest.writeValue(supportUrl);
    }

    public int describeContents() {
        return 0;
    }

}
