package com.codemachine.rickandmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.codemachine.rickandmorty.data.datasource.CharacterPagingDataSource
import com.codemachine.rickandmorty.data.model.CharacterResponse
import com.codemachine.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dataSource: CharacterPagingDataSource,
) : CharacterRepository {

    override fun getCharacters(): Flow<PagingData<CharacterResponse>> =
        Pager(PagingConfig(pageSize = 5)) { dataSource }.flow
}