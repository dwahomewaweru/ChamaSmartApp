package com.example.chamasmart.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.chamasmart.data.AppDatabase
import com.example.chamasmart.data.Contribution
import com.example.chamasmart.data.ContributionDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ContributionViewModel(application: Application) : AndroidViewModel(application) {
    private val contributionDao: ContributionDao = AppDatabase.getDatabase(application).contributionDao()

    fun insert(contribution: Contribution) = viewModelScope.launch {
        contributionDao.insert(contribution)
    }

    fun getContributionsForMember(memberId: Int): Flow<List<Contribution>> {
        return contributionDao.getContributionsForMember(memberId)
    }

    fun getTotalSavings(): Flow<Double?> {
        return contributionDao.getTotalSavings()
    }
}