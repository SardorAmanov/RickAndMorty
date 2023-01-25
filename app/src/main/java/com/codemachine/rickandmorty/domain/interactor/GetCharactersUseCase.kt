package com.codemachine.rickandmorty.domain.interactor

import androidx.paging.PagingData
import androidx.paging.map
import com.codemachine.rickandmorty.data.model.CharacterResponse
import com.codemachine.rickandmorty.domain.mapper.base.Mapper
import com.codemachine.rickandmorty.domain.model.Character
import com.codemachine.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository,
    private val mapper: Mapper<CharacterResponse, Character>
) {

    fun invoke(): Flow<PagingData<Character>> =
        repository.getCharacters().map { pagingData ->
            pagingData.map { characterResponse ->
                mapper.map(characterResponse)
            }
        }
}