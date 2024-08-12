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
import kotlinx.coroutines.delay

// #0 첫화면
@Composable
fun GreetingScreen(navController: NavHostController) {
    var isLoading by remember { mutableStateOf(true) }

    // 3초 후에 상태를 업데이트
    LaunchedEffect(Unit) {
        delay(3000L) // 3초 대기
        isLoading = false // 로딩이 끝남
        navController.navigate("selectUser") // SelectUser 화면으로 전환
    }

    if (isLoading) {
        // 로딩 중일 땐 첫 화면(Greeting)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF73BBA3)), // 배경색
            contentAlignment = Alignment.Center // 중앙 정렬
        ) {
            // helse 로고 이미지 추가
            val image = painterResource(id = R.mipmap.helselogo)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )
        }
    }
}
