package com.pooyan.domain.user

import com.pooyan.dev.model.user.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    val userData: Flow<UserData>

    suspend fun setTwitterAccount(twitterAccount: String)
}