package com.example.projecthelse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projecthelse.ui.theme.ProjectHelseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectHelseTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost()
                }
            }
        }
    }
}

// 24.08.11 진행상황
/*
frontend (1)
- 첫 화면 ---------- ok
- 사용자 선택 -------- (ing)
- 도움말 ------------------- ok
- 회원가입
- 로그인 ------------ (ing)
- 홈 화면
    (1) 카테고리 화면
    (2) 교육 카테고리 관련 화면 구현
    (3) 마이페이지
    (4) 알림창
 */