package org.hogwarts.harrypotter.data.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.hogwarts.harrypotter.data.remote.response.CharacterResponse

class HPApi(
    private val client: HttpClient,
) {
    suspend fun getAllCharacters(): Result<List<CharacterResponse>> = runCatching {
        client.get("/characters").body()
    }

    suspend fun getStudents(): Result<List<CharacterResponse>> = runCatching {
        client.get("/characters/students").body()
    }

    suspend fun getStaff(): Result<List<CharacterResponse>> = runCatching {
        client.get("/characters/staff").body()
    }
}
