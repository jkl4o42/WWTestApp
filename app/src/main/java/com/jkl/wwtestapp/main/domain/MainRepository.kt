package com.jkl.wwtestapp.main.domain

interface MainRepository {

    suspend fun config(): ConfigFact

}