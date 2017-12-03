package com.example.biz_41.Model.retrofit_package;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Karl on 26.07.2017.
 */

public interface BizGidApi {
    @GET("api/enterprises/search?")
    //Observable<List<Company>> getData(@Query("offset") int offset, @Query("amount") int amount);
    Observable<List<Company>>  getData(@Query("categoryIds") String categoryIds, @Query("regionIds") String regionIds, @Query("offset") int offset, @Query("amount") int amount);


    @GET("api/enterprises/text-search/{text}?")
    Observable<List<Company>> getDataByText(@Path(value = "text", encoded = true)  String text, @Query("offset") int offset, @Query("amount") int amount);

    @GET("api/enterprises/{enterpriseName}")
    Observable<Company> getEnterprise(@Path(value = "enterpriseName", encoded = true) String enterpriseName);
}
