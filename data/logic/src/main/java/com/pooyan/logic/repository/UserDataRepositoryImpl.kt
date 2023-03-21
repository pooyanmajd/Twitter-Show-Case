package com.pooyan.logic.repository

import com.pooyan.dev.datastore.PreferenceDataStore
import com.pooyan.dev.model.user.UserData
import com.pooyan.domain.user.UserDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(private val preferenceDataStore: PreferenceDataStore) :
    UserDataRepository {

    override val userData: Flow<UserData>
        get() = preferenceDataStore.userData

    override suspend fun setTwitterAccount(twitterAccount: String) {
        preferenceDataStore.setTwitterAccount(twitterAccount)
    }
}