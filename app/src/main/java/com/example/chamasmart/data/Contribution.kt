package com.example.chamasmart.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "contributions",
    foreignKeys = [ForeignKey(entity = Member::class, parentColumns = ["id"], childColumns = ["memberId"], onDelete = ForeignKey.CASCADE)]
)
data class Contribution(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val memberId: Int,
    val amount: Double,
    val date: String,  // Use ISO format, e.g., "2025-08-19"
    val notes: String
)