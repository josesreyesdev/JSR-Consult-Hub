package com.jsrdev.jsrconsulthub.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Token(
    @PrimaryKey val token: String
)