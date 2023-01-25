package com.codemachine.rickandmorty.domain.mapper

import com.codemachine.rickandmorty.data.model.CharacterResponse
import com.codemachine.rickandmorty.domain.mapper.base.Mapper
import com.codemachine.rickandmorty.domain.model.Location
import com.codemachine.rickandmorty.domain.model.Origin
import com.codemachine.rickandmorty.domain.model.Character
import com.codemachine.rickandmorty.domain.model.getCharacterStatusEnum
import javax.inject.Inject

class CharacterMapper @Inject constructor(): Mapper<CharacterResponse, Character>() {
    override fun map(from: CharacterResponse) = from.run {
        Character(
            id = id,
            name = name,
            status = getCharacterStatusEnum(status),
            species = species,
            type = type,
            gender = gender,
            origin = Origin(
                origin.name,
                origin.url
            ),
            image = image,
            url = url,
            location = Location(
                name = name,
                url = url
            ),
            episode = episode
        )
    }
}