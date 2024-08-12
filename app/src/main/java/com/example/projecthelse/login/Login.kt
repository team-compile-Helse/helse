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
import androidx.navigation.NavController

// #1-2 로그인 화면
@Composable
fun LoginScreen(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // 취소 버튼
        val backButton_1 = painterResource(id = R.mipmap.back_button2)

        Image(painter = backButton_1,
            contentDescription = "back button",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(30.dp) // 위치조정다시
                .clickable {
                    navController.navigate("selectUser")
                }
        )

        // 로그인

        // 아이디, 비번 입력칸

        // 완료버튼

        // 로그인 유지

        // 아이디.비번찾기

        // 간편로그인


    }

}

@Preview
@Composable
fun LoginPreview(){
    ProjectHelseTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}