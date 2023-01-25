package com.codemachine.rickandmorty.di

import com.codemachine.rickandmorty.data.repository.CharacterRepositoryImpl
import com.codemachine.rickandmorty.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharacterRepository(
        repository: CharacterRepositoryImpl
    ): CharacterRepository
}