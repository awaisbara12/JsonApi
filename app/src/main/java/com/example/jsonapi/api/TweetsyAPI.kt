package com.example.jsonapi.api

import com.example.jsonapi.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header //dynamic
import retrofit2.http.Headers //for static

interface TweetsyAPI {

    @GET("/v3/b/6525491d0574da7622b6fa85?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category :String) : Response<List<TweetListItem>>

    @GET("/v3/b/6525491d0574da7622b6fa85?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>
}