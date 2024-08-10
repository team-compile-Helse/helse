package com.example.projecthelse

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projecthelse.helpscreen.HelpHelseScreen
import com.example.projecthelse.login.LoginScreen
import com.example.projecthelse.login.SelectUserScreen
import kotlinx.coroutines.delay

// 경로 설정
@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "greeting") {
        composable("greeting") { GreetingScreen(navController) } // 첫화면
        composable("selectUser") { SelectUserScreen(navController) } // 사용자 선택
        composable("helphelse") { HelpHelseScreen(navController) } // 도움말
        composable("login"){LoginScreen(navController)} // 로그인

    }

    /*NavHost(navController, startDestination = "login"){
        composable("login"){LoginScreen(navController)} // 로그인
        // 아이디/비번찾기
        // 간편로그인(카카오, 구글, 네이버)
    }*/
}