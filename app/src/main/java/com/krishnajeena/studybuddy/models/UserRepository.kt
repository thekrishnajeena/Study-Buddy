package com.krishnajeena.studybuddy.models

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun fetchUserData() : UserData{
        delay(2000)
        return UserData("Krishna")
    }
}