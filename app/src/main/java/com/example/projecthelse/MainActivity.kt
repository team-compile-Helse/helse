package com.example.projecthelse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projecthelse.ui.theme.ProjectHelseTheme

class MainActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels()

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

// 24.08.26 진행상황
/*
frontend (1)
- 첫 화면 ---------- ok
- 사용자 선택 -------- ok
- 도움말 ------------------- ok

- 회원가입 ------------ (ing)
ㄴ 회원가입 도움말 디자인 수정(피그마)
ㄴ 관심사 설정 화면

- 로그인 ------------ (ing)
ㄴ 버튼 이벤트 설정(로그인 유지, 비밀번호 보이게 하기)
ㄴ 간편 로그인 연결
ㄴ 비밀번호 찾기 화면(버튼 이벤트 설정(알림창 등))

- 전체메뉴 ----------- ok
ㄴ 각각 페이지 이동 경로 설정해줄 것


- 홈화면
- 마이페이지
- 교육수강
- 수강현황
- 교육매칭
- 알림창

 */


/*
2024.08.23
1.사용자 선택(노인,자봉)에서 클릭시 로그인 화면으로 안 넘어감(단순 렉인지)
2. 이름, 전화번호 등 정보 저장해야하는 변수 추가하기
*/