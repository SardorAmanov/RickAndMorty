package com.codemachine.rickandmorty.data.model

data class PageResponse(
    val info: PageInfoResponse,
    val results: List<CharacterResponse>
)