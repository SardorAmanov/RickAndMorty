package com.codemachine.rickandmorty.domain.mapper.base

abstract class Mapper<From, To> {
    abstract fun map(from: From): To
}