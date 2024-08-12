package com.example.projecthelse.helpscreen

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import org.w3c.dom.Text
import androidx.compose.material3.Text

// #0-1-1 도움말 화면
@Composable
fun HelpHelseScreen(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // 도움말 내용
        val helpContent = painterResource(id = R.mipmap.help)
        Image(
            painter = helpContent,
            contentDescription = "Help Helse content",
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        )

        // 뒤로 가기 버튼 이미지
        val backButton = painterResource(id = R.mipmap.back_botton1)
        Image(
            painter = backButton,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 50.dp, top = 60.dp)
                .clickable {
                    Log.d("click", "click")
                    navController.navigate("selectUser")
                } // 버튼
        )

    }
}

@Preview
@Composable
fun HelpHelsePreview(){
    ProjectHelseTheme {
        val navController = rememberNavController()
        HelpHelseScreen(navController)
    }
}