package com.krishnajeena.studybuddy.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishnajeena.studybuddy.models.UserData
import com.krishnajeena.studybuddy.models.UserRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val userRepository: UserRepository = UserRepository()

    private val _userData = MutableLiveData<UserData>()
    val userData: LiveData<UserData> = _userData

    init {
        getUserData()
    }

    private fun getUserData(){
        viewModelScope.launch {
        val userResult = userRepository.fetchUserData()
            _userData.postValue(userResult)
        }
    }
}