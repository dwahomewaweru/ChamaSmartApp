package com.example.chamasmart.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.chamasmart.data.AppDatabase
import com.example.chamasmart.data.Member
import com.example.chamasmart.data.MemberDao
import kotlinx.coroutines.launch

class MemberViewModel(application: Application) : AndroidViewModel(application) {
    private val memberDao: MemberDao = AppDatabase.getDatabase(application).memberDao()
    val allMembers = memberDao.getAllMembers()

    fun insert(member: Member) = viewModelScope.launch {
        memberDao.insert(member)
    }
}