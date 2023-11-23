package uz.itschool.mathkidsnew.screens.questionscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.mathkidsnew.MisolMaker
import uz.itschool.mathkidsnew.MySharedPreferences
import uz.itschool.mathkidsnew.R
import kotlin.random.Random


@Composable
fun QuestionScreen(navController: NavController, level: String) {
    val sharedPreferences = MySharedPreferences.getInstance(LocalContext.current)
    val score = remember { mutableStateOf(0) }
    val questionsAmount = remember {
        mutableStateOf(0)
    }
    val test = remember {
        mutableStateOf(MisolMaker.generate(level))
    }
    Box(
        modifier = with(Modifier) {
            fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.questions_img),
                    contentScale = ContentScale.Crop
                )

        })
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Score: " + score.value.toString(),
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp).background(
                        color = Color.White,
                        shape = CircleShape
                    ) ,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = test.value.a.toString(), color = Color.Black, fontSize = 45.sp)
                Text(text = " _ ", color = Color.Black, fontSize = 45.sp)
                Text(text = test.value.b.toString(), color = Color.Black, fontSize = 45.sp)
                Text(text = " = ", color = Color.Black, fontSize = 45.sp)
                Text(text = test.value.c.toString(), color = Color.Black, fontSize = 45.sp)

            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.plus_btn), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable {
                            if (test.value.sign == "+") {
                                score.value++
                                sharedPreferences.setData(level, score.value)
                            }
                            test.value = MisolMaker.generate(level)
                            questionsAmount.value++
                            if (questionsAmount.value == 10){
                                navController.navigate(route = "record_screen/${level}/${score.value}/${questionsAmount.value}")
                            }

                        }
                        .height(80.dp)
                        .width(80.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.minus_btn), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable {
                            if (test.value.sign == "-") {
                                score.value++
                                sharedPreferences.setData(level, score.value)
                            }
                            test.value = MisolMaker.generate(level)
                            questionsAmount.value++
                            if (questionsAmount.value == 10){
                                navController.navigate(route = "record_screen/${level}/${score.value}/${questionsAmount.value}")
                            }
                        }
                        .height(80.dp)
                        .width(80.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.multi_btn), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable {
                            if (test.value.sign == "*") {
                                score.value++
                                sharedPreferences.setData(level, score.value)
                            }
                            test.value = MisolMaker.generate(level)
                            questionsAmount.value++
                            if (questionsAmount.value == 10){
                                navController.navigate(route = "record_screen/${level}/${score.value}/${questionsAmount.value}")
                            }
                        }
                        .height(80.dp)
                        .width(80.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.div_btn), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable {
                            if (test.value.sign == "/") {
                                score.value++
                                sharedPreferences.setData(level, score.value)
                            }
                            test.value = MisolMaker.generate(level)
                            questionsAmount.value++
                            if (questionsAmount.value == 10){
                                navController.navigate(route = "record_screen/${level}/${score.value}/${questionsAmount.value}")
                            }
                        }
                        .height(80.dp)
                        .width(80.dp)
                )
            }
        }
    }

}
