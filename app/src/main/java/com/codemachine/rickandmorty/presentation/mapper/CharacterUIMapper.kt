package com.codemachine.rickandmorty.presentation.mapper

import com.codemachine.rickandmorty.domain.mapper.base.Mapper
import com.codemachine.rickandmorty.domain.model.Character
import com.codemachine.rickandmorty.domain.model.CharacterStatus
import com.codemachine.rickandmorty.presentation.model.CharacterStatusUI
import com.codemachine.rickandmorty.presentation.model.CharacterUI
import com.codemachine.rickandmorty.presentation.model.LocationUI
import com.codemachine.rickandmorty.presentation.model.OriginUI
import javax.inject.Inject

class CharacterUIMapper @Inject constructor(): Mapper<Character, CharacterUI>() {
    override fun map(from: Character) = from.run {
        CharacterUI(
            id = id,
            name = name,
            status = status.convertToUI(),
            species = species,
            type = type,
            gender = gender,
            origin = OriginUI(
                origin.name,
                origin.url
            ),
            image = image,
            url = url,
            location = LocationUI(
                name = name,
                url = url
            ),
            episode = episode
        )
    }
}

fun CharacterStatus.convertToUI(): CharacterStatusUI {
    return when (this) {
        CharacterStatus.ALIVE -> CharacterStatusUI.ALIVE
        CharacterStatus.DEAD -> CharacterStatusUI.DEAD
        CharacterStatus.UNKNOWN -> CharacterStatusUI.UNKNOWN
    }
}
