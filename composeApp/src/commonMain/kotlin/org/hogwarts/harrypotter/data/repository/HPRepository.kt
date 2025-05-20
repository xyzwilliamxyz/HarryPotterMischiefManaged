package org.hogwarts.harrypotter.data.repository

import org.hogwarts.harrypotter.data.mapper.HPMapper
import org.hogwarts.harrypotter.data.remote.api.HPApi
import org.hogwarts.harrypotter.domain.model.Character

class HPRepository(
    private val api: HPApi,
    private val mapper: HPMapper,
) {
    suspend fun getAllCharacters(): Result<List<Character>> {
        return api.getAllCharacters().map { response -> mapper.toDomain(response) }
    }

    suspend fun getStudents(): Result<List<Character>> {
        return api.getStudents().map { response -> mapper.toDomain(response) }
    }

    suspend fun getStaff(): Result<List<Character>> {
        return api.getStaff().map { response -> mapper.toDomain(response) }
    }
}
