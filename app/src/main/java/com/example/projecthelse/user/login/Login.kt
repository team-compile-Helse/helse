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
import android.widget.TextView
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// #1-2 로그인 화면
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController){
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) } // 체크 상태
    var showAlertDialog by remember { mutableStateOf(false) } // 다이얼로그 표시 상태
    var alertDialogMessage by remember { mutableStateOf("") } // 다이얼로그에 표시할 메시지

    // 로그인시 전화번호 숫자 11자리만 입력되도록 제한
    fun onphoneNumberPartChange(newValue: String) {
        val filteredValue = newValue.filter { it.isDigit() }
        if (filteredValue.length <= 11) {
            phoneNumber = filteredValue
        }
    }

    // 전화번호, 비밀번호 모두 입력 시 홈화면으로 이동
    fun onCompleteClick(){
       when{
           phoneNumber.isEmpty() || password.isEmpty() ->{
               alertDialogMessage = "전화번호와 비밀번호를 입력해주세요"
               showAlertDialog = true
           }

           /*phoneNumber != validPhoneNumber || password != balidPassword ->{
              // 전번, 비번 맞는지 확인하는 코드
           }*/
           else ->{
               navController.navigate("home")
           }
       }
    }

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
                .padding(30.dp)
                .clickable {
                    navController.navigate("selectUser")
                }
        )

        // 로그인
        Text(
            text = "로그인",
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-250).dp)
        )
        Spacer(modifier = Modifier.height(200.dp))

        // 아이디, 비번 입력칸

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (70).dp)
        ) {
            // 전화번호 입력칸
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 16.dp)

            ) {

                TextField(
                    value = phoneNumber,
                    onValueChange = { onphoneNumberPartChange(it) },
                    placeholder = { Text("'-'를 제외한 전화번호를 입력해주세요") },
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

            Spacer(modifier = Modifier.height(15.dp)) // 아이디와 비밀번호 사이 간격
            val pwdsaw = painterResource(id = R.mipmap.pwdsaw)

            // 비밀번호 입력칸
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(Color.Transparent)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ) {
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text("비밀번호를 입력해주세요") },
                        modifier = Modifier
                            .padding(start = 12.dp) // 이미지 안쪽에 여백 추가
                            .background(Color.Transparent)
                            .size(width = 350.dp, height = 60.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(30.dp),// 모서리를 둥글게 설정
                        // 비밀번호 보이게 하는 아이콘
                        trailingIcon = {
                            Image(
                                painter = painterResource(id = R.mipmap.pwdsaw), // 여기에 사용할 이미지 리소스 ID를 입력
                                contentDescription = "null",
                                modifier = Modifier
                                    .size(22.dp)
                                    .padding(start = (-8).dp)
                            )
                        }
                    )
                }

            }

            Spacer(modifier = Modifier.height(10.dp))

            // 로그인 유지
            // 아이디.비번찾기
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            ) {
                // 동그라미
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            if (isChecked) Color(0xFF73BBA3) else Color.White, // 체크 여부에 따라 색상 변경
                            shape = RoundedCornerShape(50.dp) // 동그라미 모양
                        )
                        .clickable {
                            isChecked = !isChecked // 클릭 시 체크 상태 변경
                        }
                        .border(2.dp, Color(0xFF73BBA3), shape = RoundedCornerShape(50.dp)) // 동그라미 테두리
                )

                Spacer(modifier = Modifier.width(8.dp))

                // 로그인 유지 텍스트
                Text(
                    text = "로그인 유지",
                    color = Color(0xFF515151),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.width(150.dp))

                Box(
                    modifier = Modifier
                        .clickable {
                            // 비번 찾기 사이트 이동
                            navController.navigate("findpwd")
                        }
                ){
                    Text(text = "비밀번호 찾기",
                        color = Color(0xFF515151),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

            }

            Spacer(modifier = Modifier.height(15.dp))

            // 완료 버튼
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
                        onCompleteClick()
                    }
                    .height(60.dp) // 버튼의 높이 설정
                    .align(Alignment.CenterHorizontally) // 가운데 정렬
                    .padding(horizontal = 16.dp) // 좌우 여백
            ){
                Text(
                    text = "완료",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Center) // 텍스트를 가운데 정렬
                        .padding(horizontal = 16.dp) // 좌우 여백
                )
            }

            // 간편로그인
            val easyloginbar = painterResource(id = R.mipmap.easyloginbar)
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .padding(horizontal = 16.dp)

            ){
                Image(painter = easyloginbar,
                    contentDescription = "null",
                    modifier = Modifier
                        .size(width = 400.dp, height = 100.dp)
                )
            }

            // 카카오.네이버.구글 이미지
            val kakaoImg = painterResource(id = R.mipmap.kakao)
            val naverImg = painterResource(id = R.mipmap.naver)
            val googleImg = painterResource(id = R.mipmap.google)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                    //.padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = kakaoImg,
                    contentDescription = "null",
                    modifier = Modifier
                        .size(60.dp))
                Spacer(modifier = Modifier.width(30.dp))
                Image(painter = naverImg,
                    contentDescription = "null",
                    modifier = Modifier
                        .size(50.dp))
                Spacer(modifier = Modifier.width(30.dp))
                Image(painter = googleImg,
                    contentDescription = "null",
                    modifier = Modifier
                        .size(50.dp))
            }

        }

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
fun LoginPreview(){
    ProjectHelseTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}