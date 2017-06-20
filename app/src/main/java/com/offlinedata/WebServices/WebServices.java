package com.offlinedata.WebServices;






import com.offlinedata.Resonse.MainResponse;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.QueryMap;


public interface WebServices {













    @POST("/clientsHomeworkList")
    public void getAllData(@QueryMap Map<String, String> map, Callback<MainResponse> callback);



}







