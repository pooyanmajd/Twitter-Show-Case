package com.pooyan.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pooyan.domain.user.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userDataRepository: UserDataRepository) : ViewModel() {

    fun onTwitterNameSelected(twitterAccount: String) {

        viewModelScope.launch {
            userDataRepository.setTwitterAccount(twitterAccount)
        }
    }
}