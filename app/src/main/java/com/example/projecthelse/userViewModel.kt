package com.example.projecthelse

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    companion object {
        private var userName: String = ""

        // 사용자 이름 설정
        fun setUserName(name: String) {
            userName = name
        }

        // 사용자 이름 가져오기
        fun getUserName(): String {
            return userName
        }
    }
}