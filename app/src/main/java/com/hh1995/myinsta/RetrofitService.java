package com.hh1995.myinsta;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;

public interface RetrofitService {
    @Multipart
    @POST("/Diary/insertDB.php")
    Call<String> postDataToDiary(@PartMap Map<String,String> dataPart,
                                 @Part MultipartBody.Part filePart);

    @Multipart
    @POST("/Home/insertDB.php")
    Call<String> postDataToHome(@PartMap Map<String,String> dataPart,
                                 @Part MultipartBody.Part filePart);

    @GET("/Diary/loadDB.php")
    Call<ArrayList<DiaryItem>> loadDataFromDiary();

    @GET("/Home/loadDB.php")
    Call<ArrayList<HomeItem>> loadDataFromHome();

    @PUT("/Home/{filename}")
    Call<HomeItem> updateData(@Path("filename") String filename,
                               @Body HomeItem item);
}
