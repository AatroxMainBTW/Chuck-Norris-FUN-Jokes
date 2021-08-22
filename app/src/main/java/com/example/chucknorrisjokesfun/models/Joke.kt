package com.example.chucknorrisjokesfun.models

import java.lang.reflect.Constructor

data class Joke(
    val categories: List<String>,
    val created_at: String,
    val icon_url: String,
    val id: String,
    val updated_at: String,
    val url: String,
    val value: String

) {
    constructor() : this(listOf(),"","","","","","")
}