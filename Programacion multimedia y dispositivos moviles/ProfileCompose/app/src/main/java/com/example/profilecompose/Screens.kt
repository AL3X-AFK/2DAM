package com.example.profilecompose

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
data class User(val username: String, val password: String)

@Serializable
object Searcher

@Serializable
data class Profile (val name: String)

@Serializable
data class Detail(val name: String)