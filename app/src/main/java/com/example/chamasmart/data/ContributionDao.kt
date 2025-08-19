package com.example.chamasmart.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContributionDao {
    @Insert
    suspend fun insert(contribution: Contribution)

    @Query("SELECT * FROM contributions WHERE memberId = :memberId")
    fun getContributionsForMember(memberId: Int): Flow<List<Contribution>>

    @Query("SELECT SUM(amount) FROM contributions")
    fun getTotalSavings(): Flow<Double?>
}