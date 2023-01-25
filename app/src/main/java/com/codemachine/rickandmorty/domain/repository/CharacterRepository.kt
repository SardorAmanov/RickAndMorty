package com.codemachine.rickandmorty.domain.repository

import androidx.paging.PagingData
import com.codemachine.rickandmorty.data.model.CharacterResponse
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters(): Flow<PagingData<CharacterResponse>>
}