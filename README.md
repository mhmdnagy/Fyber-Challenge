#Fyber-Challenge

This is sample app that retrives a list of offers.

#Summary

This demo is based on MVP and uses RxJava to communicate between the data layer and the presenters. The data layer uses Observers to send data back to the presenter. You can find methods like that in the OffersDataSource:

```java
Observable<Response<ResponseBody>> getOffers(String appId, String ip, String locale, String offer_type,
                                                 String timestamp, String uId, String token);
```

The `OffersRepository` is responsible for managing data between the remote data souce and local data souce. 

# Depedencies 

* RxJava
* Retrofit 2
* Picasso
* Mockito
