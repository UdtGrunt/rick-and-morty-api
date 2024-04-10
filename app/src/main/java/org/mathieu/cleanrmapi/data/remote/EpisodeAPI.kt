package org.mathieu.cleanrmapi.data.remote

import org.mathieu.cleanrmapi.data.remote.responses.EpisodeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeAPI {
    /**
     * `getEpisodes` is a function that represents a GET request to the "episode/{ids}" endpoint.
     * This function is suspended because it performs a network operation which is a long-running task.
     *
     * @property ids List of episode IDs to fetch from the API.
     * @return List of `EpisodeResponse` objects corresponding to the requested episode IDs.
     */
    @GET("episode/{ids}")
    suspend fun getEpisodes(@Path("ids") ids : List<Int>): List<EpisodeResponse>
}