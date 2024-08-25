package com.example.projecthelse.user.login

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
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

// #1-2 비밀번호 찾기 화면
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindPwdScreen(navController: NavHostController){
    // 이름
    var userName by remember { mutableStateOf("") }
    // 전화번호
    var middlePart by remember { mutableStateOf("") }
    var lastPart by remember { mutableStateOf("") }

    // 인증번호
    var code by remember {mutableStateOf("") }

    // 인증번호 발송 상태 및 입력창 표시 상태를 관리하는 변수
    var showInput by remember { mutableStateOf(false) }
    var showSnackbar by remember { mutableStateOf(false) }

    var showAlertDialog by remember { mutableStateOf(false) } // 다이얼로그 표시 상태
    var alertDialogMessage by remember { mutableStateOf("") } // 다이얼로그에 표시할 메시지

    // 중간 부분 텍스트 필드에서 숫자 4자리만 입력되도록 제한
    fun onMiddlePartChange(newValue: String) {
        val filteredValue = newValue.filter { it.isDigit() }
        if (filteredValue.length <= 4) {
            middlePart = filteredValue
        }
    }

    // 뒷자리 부분 텍스트 필드에서 숫자 4자리만 입력되도록 제한
    fun onLastPartChange(newValue: String) {
        val filteredValue = newValue.filter { it.isDigit() }
        if (filteredValue.length <= 4) {
            lastPart = filteredValue
        }
    }

    // 인증코드 발송 알림 함수
    fun onSendAuthCode(){
        showSnackbar = true // 알림 표시
        showInput = true // 입력창 표시
    }

    // 비밀번호 찾기 버튼 클릭 전 모든 정보 입력 했는지 체크하는 함수
    fun onCompleteClick(){
        when{
            userName.isEmpty() || middlePart.isEmpty() || lastPart.isEmpty()
                    || code.isEmpty() ->{
                alertDialogMessage = "모든 정보를 입력해주세요."
                showAlertDialog = true
            }
            else ->{
               //navController.navigate(새로운 비번 생성 페이지)
            }
        }
    }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Text(
                text = "이름",
                color = Color(0xFF515151),
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 30.dp, top = 150.dp) // 텍스트를 아래로 이동
            )

            // 이름 입력칸
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp) // 이름 텍스트와 입력칸 사이 간격
            ) {
                TextField(
                    value = userName,
                    onValueChange = { userName = it },
                    placeholder = { Text("이름을 입력해주세요.") },
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .background(Color.Transparent)
                        .size(width = 350.dp, height = 60.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(30.dp) // 모서리 둥글게
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            // 전화번호
            Text(
                text = "전화번호",
                color = Color(0xFF515151),
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 30.dp)
            )

            // 전화번호 입력 칸
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp) // 이름 텍스트와 입력칸 사이 간격
            ) {
                // 첫 번째 입력칸 (010)
                TextField(
                    value = "010",
                    onValueChange = {},
                    placeholder = { Text("010") },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(start = 7.dp)
                        .size(width = 80.dp, height = 60.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(30.dp) // 모서리 둥글게
                )

                // 입력칸 사이의 간격
                Spacer(modifier = Modifier.width(3.dp))

                // 두 번째 입력칸 (중간 부분)
                TextField(
                    value = middlePart,
                    onValueChange = { onMiddlePartChange(it) },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(start = 7.dp)
                        .size(width = 80.dp, height = 60.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(30.dp) // 모서리 둥글게
                )

                // 입력칸 사이의 간격
                Spacer(modifier = Modifier.width(3.dp))

                // 세 번째 입력칸 (뒷자리)
                TextField(
                    value = lastPart,
                    onValueChange = { onLastPartChange(it)},
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(start = 7.dp)
                        .size(width = 80.dp, height = 60.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(30.dp) // 모서리 둥글게
                )

                // 입력칸 사이의 간격
                Spacer(modifier = Modifier.width(5.dp))


                // 세 번째 입력칸 (인증번호 버튼)
                Box(
                    modifier = Modifier
                        .size(width = 200.dp, height = 60.dp)
                        .background(Color.White)
                        .padding(start = 10.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFF73BBA3),
                            shape = RoundedCornerShape(30.dp)
                        )
                        .clickable {
                            // 누르면 인증번호 발송 알림 및 인증번호 입력 창 뜨기
                            onSendAuthCode()
                        }
                ){
                    Text(
                        text = "인증번호",
                        color = Color(0xFF73BBA3),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.Center) // 텍스트를 가운데 정렬
                            .padding(horizontal = 16.dp) // 좌우 여백
                    )
                }

            }

            // 인증번호 발송 알림
            if(showSnackbar){
                Text(
                    text = "인증번호가 발송되었습니다.",
                    color = Color(0xFF73BBA3),
                    modifier = Modifier.padding(start = 20.dp, top = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            // 인증번호 입력칸
            if(showInput){
                Text(
                    text = "인증번호",
                    color = Color(0xFF515151),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 30.dp)
                )

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp) // 이름 텍스트와 입력칸 사이 간격
                ) {

                    // 인증번호 입력칸

                    TextField(
                        value = code,
                        onValueChange = { code = it },
                        placeholder = { Text("인증번호를 입력해주세요.") },
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(start = 7.dp)
                            .size(width = 270.dp, height = 60.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(30.dp) // 모서리 둥글게
                    )

                    // 입력칸 사이의 간격
                    Spacer(modifier = Modifier.width(3.dp))

                    // 인증번호 확인 버튼
                    Box(
                        modifier = Modifier
                            .size(width = 100.dp, height = 60.dp)
                            .background(Color.White)
                            .padding(start = 10.dp)
                            .border(
                                width = 2.dp,
                                color = Color(0xFF73BBA3),
                                shape = RoundedCornerShape(30.dp)
                            )
                            .clickable {
                                // 누르면 인증번호 확인
                            }
                    ){
                        Text(
                            text = "확인",
                            color = Color(0xFF73BBA3),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.Center) // 텍스트를 가운데 정렬
                                .padding(horizontal = 16.dp) // 좌우 여백
                        )
                    }

                }
            }

            Spacer(modifier = Modifier.height(50.dp))
            // 비밀번호 찾기 버튼
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally) // 가로 정렬 가운데
                    .background(
                        Color(0xFF73BBA3),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .clickable {
                        // 비밀번호 재설정 사이트
                    }
                    .height(60.dp) // 버튼의 높이 설정
                    .align(Alignment.CenterHorizontally) // 가운데 정렬
                    .padding(horizontal = 16.dp) // 좌우 여백
            ){
                Text(
                    text = "비밀번호찾기",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Center) // 텍스트를 가운데 정렬
                        .padding(horizontal = 16.dp) // 좌우 여백
                        .clickable {
                            onCompleteClick()
                        }
                )
            }
        }


        // 취소 버튼
        val backButton_1 = painterResource(id = R.mipmap.back_button2)

        Image(
            painter = backButton_1,
            contentDescription = "back button",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(30.dp)
                .clickable {
                    navController.navigate("login")
                }
        )

        // 알림창
        if (showAlertDialog) {
            AlertDialog(
                onDismissRequest = {
                    showAlertDialog = false
                },
                title = {
                    Text(text = "알림")
                },
                text = {
                    Text(text = alertDialogMessage)
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showAlertDialog = false
                        }
                    ) {
                        Text("확인")
                    }
                }
            )
        }
    }
}


@Preview
@Composable
fun FindPwdPreview(){
    ProjectHelseTheme {
        val navController = rememberNavController()
        FindPwdScreen(navController = navController)
    }
}