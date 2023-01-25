package com.codemachine.rickandmorty.di

import com.codemachine.rickandmorty.data.model.CharacterResponse
import com.codemachine.rickandmorty.domain.mapper.CharacterMapper
import com.codemachine.rickandmorty.domain.mapper.base.Mapper
import com.codemachine.rickandmorty.domain.model.Character
import com.codemachine.rickandmorty.presentation.mapper.CharacterUIMapper
import com.codemachine.rickandmorty.presentation.model.CharacterUI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindCharacterMapper(
        mapper: CharacterMapper
    ): Mapper<CharacterResponse, Character>

    @Binds
    abstract fun bindCharacterUIMapper(
        mapper: CharacterUIMapper
    ): Mapper<Character, CharacterUI>
}