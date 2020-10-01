package com.alejandrorios.data.service

import com.alejandrorios.data.entities.APIAnimeTrends
import retrofit2.http.GET

/**
 * @author alejandrorios on 8/11/20
 */
interface AnimeService {

    @GET("anime?filter%5Bstatus%5D=current&page%5Blimit%5D=20&sort=-userCount")
    suspend fun getAnimeTrends(): APIAnimeTrends
}
