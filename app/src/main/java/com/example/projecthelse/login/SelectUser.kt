package com.example.projecthelse.login

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projecthelse.R
import com.example.projecthelse.ui.theme.ProjectHelseTheme
import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

// #0-1 시작화면(사용자 선택)
@Composable
fun SelectUserScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        // 도움말 버튼
        val helphelse = painterResource(id = R.mipmap.help_helse)
        Image(
            painter = helphelse,
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.TopEnd)
                .clickable {
                    navController.navigate("helphelse")  // 페이지 이동
                }
                .padding(16.dp)
        )


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,  // 가로 정렬 가운데
            //verticalArrangement = Arrangement.Center  // 세로 정렬 가운데
        ) {
            Spacer(modifier = Modifier.height(200.dp))
            // 어르신 버튼
            val select_senior = painterResource(id = R.mipmap.select_senior)
            Image(
                painter = select_senior,
                contentDescription = "select senior user",
                modifier = Modifier
                    .padding(16.dp)
                    .size(200.dp)
                    .clickable {
                        // 로그인 페이지 이동
                        navController.navigate("login")
                    }
            )

            // 자원봉사자 버튼
            val select_volunteer = painterResource(id = R.mipmap.select_volunteer)
            Image(
                painter = select_volunteer,
                contentDescription = "select volunteer user",
                modifier = Modifier
                    .padding(16.dp)
                    .size(200.dp)
                    .clickable {
                        // 로그인 페이지 이동
                        navController.navigate("login")
                    }
            )

            // 여백 추가
            Spacer(modifier = Modifier.height(60.dp))

            // 회원가입 버튼
            Text(
                text = buildAnnotatedString {
                    withStyle(style = androidx.compose.ui.text.SpanStyle(
                        color = Color(0xFF436C5E), // 색
                        fontWeight = FontWeight.Bold, // 굵게
                        textDecoration = TextDecoration.Underline // 밑줄
                    )) {
                        append(stringResource(R.string.register_user)) // 회원가입(문자열)
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        navController.navigate("register") // 클릭 시 회원가입 페이지로 이동
                    }
            )
        }
    }
}

@Preview
@Composable
fun SelectUserPreview(){
    ProjectHelseTheme {
        val navController = rememberNavController()
        SelectUserScreen(navController = navController)
    }
}