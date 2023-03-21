package com.pooyan.dev.datastore

import android.util.Log
import androidx.datastore.core.DataStore
import com.pooyan.dev.model.user.UserData
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class PreferenceDataStore @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>,
) {
    val userData = userPreferences.data
        .map {
            UserData(
                selectedTwitterAccount = it.selectedTwitterAccount
            )
        }

    suspend fun setTwitterAccount(twitterAccount: String) {
        try {
            userPreferences.updateData {
                it.copy {
                    selectedTwitterAccount = twitterAccount
                }
            }
        } catch (ioException: IOException) {
            Log.e("PreferenceDataStore", "Failed to update user preferences", ioException)
        }
    }
}