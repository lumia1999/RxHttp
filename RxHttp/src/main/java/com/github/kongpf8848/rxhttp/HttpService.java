package com.github.kongpf8848.rxhttp;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface HttpService {

    /**
     * Get请求
     * @param url
     * @return
     */
    @GET
    Observable<ResponseBody> get(@Url String url);

    /**
     * Post请求
     * @param url
     * @param body
     * @return
     */
    @POST
    Observable<ResponseBody>post(@Url String url, @Body RequestBody body);

    /**
     * Post表单请求
     * @param url
     * @param map
     * @return
     */
    @POST
    @FormUrlEncoded
    Observable<ResponseBody> postForm(@Url String url, @FieldMap Map<String, Object> map);

    /**
     * 下载请求
     * @param url
     * @return
     */
    @GET
    @Streaming
    Observable<ResponseBody> download(@Url String url);




}
