package com.trubitsyna.homework

import java.util.*

data class DataModel(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val subtitle: String
)