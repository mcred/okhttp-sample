package com.delphix.okhttp

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import java.io.IOException
import java.util.concurrent.TimeUnit

object Test {

    private fun call(request: Request): ResponseBody {
        val caller = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
        val response = caller.newCall(request).execute()
        if (!response.isSuccessful) {
            throw IOException("Unexpected Code: $response")
        }
        return response.body!!
    }

    private fun get(url: String): ResponseBody {
        val request = Request.Builder()
                .url(url)
                .build()
        return call(request)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(get("https://icanhazip.com/").string())
    }
}