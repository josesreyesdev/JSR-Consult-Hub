package com.jsrdev.jsrconsulthub.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Token(
    @PrimaryKey val token: String
)