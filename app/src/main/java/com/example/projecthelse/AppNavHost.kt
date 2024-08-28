package com.example.projecthelse


import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projecthelse.helpscreen.HelpHelseScreen
import com.example.projecthelse.user.login.FindPwdScreen
import com.example.projecthelse.user.login.LoginScreen
import com.example.projecthelse.user.login.SelectUserScreen
import com.example.projecthelse.user.register.HelpRegisterPreview
import com.example.projecthelse.user.register.HelpRegisterScreen
import com.example.projecthelse.user.register.RegisterScreen

// 경로 설정
@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "greeting") {
        composable("greeting") { GreetingScreen(navController) } // 첫화면
        composable("selectUser") { SelectUserScreen(navController) } // 사용자 선택
        composable("helphelse") { HelpHelseScreen(navController) } // 도움말
        composable("login"){ LoginScreen(navController) } // 로그인
        composable("findpwd"){ FindPwdScreen(navController) } // 비밀번호찾기

        composable("register"){ RegisterScreen(navController) } // 회원가입
        composable("helpregister"){ HelpRegisterScreen(navController) } // 회원가입 가이드

    }

    /*NavHost(navController, startDestination = "login"){
        composable("login"){LoginScreen(navController)} // 로그인
        // 아이디/비번찾기
        // 간편로그인(카카오, 구글, 네이버)
    }*/
}