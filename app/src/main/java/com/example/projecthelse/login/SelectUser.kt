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

// #0-1 시작화면(사용자 선택)
@Composable
fun SelectUserScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        //contentAlignment = Alignment.Center
    ) {

        // 도움말 버튼
        val helphelse = painterResource(id = R.mipmap.help_helse)
        Image(
            painter = helphelse,
            contentDescription = null,
            modifier = Modifier
                    .size(300.dp)
                    .padding(top = 40.dp, end = 16.dp)
                    .align(Alignment.TopEnd)
                    .clickable {
                        navController.navigate("helphelse")
                    }
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,  // 가로 정렬 가운데
            verticalArrangement = Arrangement.Center  // 세로 정렬 가운데
        ){
            // 어르신 버튼
            val select_senior = painterResource(id = R.mipmap.select_senior)
            Image(painter = select_senior,
                contentDescription = "select senior user",
                modifier = Modifier.padding(16.dp)
                    .size(200.dp)


            )

            // 자원봉사자 버튼
            val select_volunteer = painterResource(id = R.mipmap.select_volunteer)
            Image(painter = select_volunteer,
                contentDescription = "select volunteer user",
                modifier = Modifier.padding(16.dp)
                    .size(200.dp)

            )
        }


        //}
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