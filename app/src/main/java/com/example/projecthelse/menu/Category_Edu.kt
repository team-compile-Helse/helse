package com.example.projecthelse.menu

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.room.util.copy
import com.example.projecthelse.user.login.FindPwdScreen

//#3 전체메뉴
@Composable
fun CategoryEduScreen(navController: NavHostController) {
    var userName by remember { mutableStateOf("") }
    var clickedBoxIndex by remember { mutableStateOf(0) } // 메뉴 클릭

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 30.dp),
        contentAlignment = Alignment.TopCenter // 중앙 정렬
    ) {

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth() // 가로 길이를 화면 끝까지 채우기
                .padding(horizontal = 16.dp), // 좌우 패딩 설정
            verticalAlignment = Alignment.CenterVertically // 세로 방향으로 중앙 정렬
        ) {

            // 취소 버튼
            val backButton_1 = painterResource(id = R.mipmap.back_button2)

            Image(painter = backButton_1,
                contentDescription = "back button",
                modifier = Modifier
                    .padding(start = 2.dp, top = 5.dp)
                    .size(20.dp)
                    .clickable {
                        // 가장 최근에 접속했던 페이지
                    }
            )

            Spacer(modifier = Modifier.weight(1f))

            // 제목
            Text(
                text = "Helse",
                color = Color(0xFF73BBA3),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp) // 좌우 여백
            )

            Spacer(modifier = Modifier.weight(1f))

            // 알림창
            var alarmImg = painterResource(id = R.mipmap.alarm)
            Image(
                painter = alarmImg,
                contentDescription = "null",
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        // 알림창 페이지로 이동
                    }
            )
        }
    }

    Box {
        var userImg = painterResource(id = R.mipmap.userimg)
        Image(
            painter = userImg,
            contentDescription = "user image",
            modifier = Modifier
                .padding(start = 20.dp, top = 100.dp)
                .size(70.dp)
        )

        //Spacer(modifier = Modifier.width(20.dp))

        val text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color(0xFFB56262), fontSize = 24.sp)) {
                append("$userName ")
            }
            withStyle(style = SpanStyle(color = Color.Black, fontSize = 20.sp)) {
                append(" 님, 반갑습니다!")
            }
        }

        Text(
            text = text,
            modifier = Modifier
                .padding(start = 95.dp, top = 113.dp)
        )
    }

    // 메인 메뉴
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row { // 메인 카테고리와 상세 메뉴
            // 메인 카테고리
            Box(
                modifier = Modifier
                    .padding(top = 200.dp)
            ) {
                Column {
                    val boxModifier = Modifier
                        .size(width = 160.dp, height = 100.dp)

                    // 각 카테고리(리스트)
                    val categories = listOf("교 육", "채용정보", "봉사정보", "이력서", "고객센터")

                    categories.forEachIndexed { index, category ->
                        Box(
                            modifier = boxModifier
                                .background(
                                    if (clickedBoxIndex == index) Color(0xFF73BBA3) else Color.White
                                ) // 클릭된 Box만 배경색 변경
                                .clickable {
                                    clickedBoxIndex = index // 클릭된 Box의 인덱스를 저장
                                }
                                .padding(0.dp)
                        ) {
                            Text(
                                text = category,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (clickedBoxIndex == index) Color.White else Color.Black, // 클릭된 Box만 글자색 변경
                                modifier = Modifier.align(Alignment.Center) // 텍스트를 Box의 중앙에 배치
                            )
                        }
                    }
                }
            }

            // 상세 메뉴
            if(clickedBoxIndex >= 0){
                Box(
                    modifier = Modifier
                        .padding(top = 200.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .size(width = 250.dp, height = 800.dp)
                            .background(Color(0x3373BBA3))
                            .padding(20.dp)
                    ) {
                        when(clickedBoxIndex){
                            0 -> { // 교육
                                Text(
                                    text = "교육수강",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                                Text(
                                    text = "교육매칭",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                                Text(
                                    text = "교육매칭(신청)",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                                Text(
                                    text = "수강현황",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                            }

                            1 -> { //채용정보
                                Text(
                                    text = "전체채용",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                                Text(
                                    text = "AI일자리추천",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                                Text(
                                    text = "최근본공고",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                                Text(
                                    text = "스크랩일자리",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                            }

                            2 -> { //봉사정보
                                Text(
                                    text = "전체봉사",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                                Text(
                                    text = "최근본봉사",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                                Text(
                                    text = "스크랩봉사",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                            }

                            3 -> { //이력서
                                Text(
                                    text = "이력서작성",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                            }

                            4 -> {
                                Text(
                                    text = "FAQ",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                                Text(
                                    text = "공지사항",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                                Text(
                                    text = "문의하기",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                                Text(
                                    text = "이용가이드",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .clickable {
                                            // 페이지 이동
                                        }
                                )
                            }
                        }

                    }
                }
            }

        }

        // 하단바(홈, 전체메뉴, 마이페이지)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomCenter)
                .background(Color(0xFFc3f2ca))
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly, // 텍스트를 일정하게 배치
                verticalAlignment = Alignment.CenterVertically // 텍스트를 수직으로 중앙 정렬
            ) {
                val boxModifierBottom = Modifier
                    .size(width = 100.dp, height = 50.dp)

                Box(
                    modifier = boxModifierBottom,
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "홈",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .clickable {
                                // 페이지 이동
                            }
                    )
                }

                Box(
                    modifier = boxModifierBottom,
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "전체메뉴",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .clickable {
                                // 페이지 이동
                            }
                    )
                }

                Box(
                    modifier = boxModifierBottom,
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "마이페이지",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .clickable {
                                // 페이지 이동
                            }
                    )
                }



            }

        }
    }
}

@Preview
@Composable
fun CategoryEduPreview(){
    ProjectHelseTheme {
        val navController = rememberNavController()
        CategoryEduScreen(navController = navController)
    }
}