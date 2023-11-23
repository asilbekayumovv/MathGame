package uz.itschool.mathkidsnew.screens.menuscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uz.itschool.mathkidsnew.R

@Composable
fun MenuScreen(navController: NavController) {
    Box(
        modifier = with(Modifier) {
            fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.menu_img),
                    contentScale = ContentScale.Crop
                )

        })
    {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.easy_btn), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable { navController.navigate("question_screen/easy")}
                    .height(80.dp)
                    .width(200.dp),
            )
            Image(painter = painterResource(id = R.drawable.normal_btn), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable { navController.navigate("question_screen/normal") }
                    .height(80.dp)
                    .width(200.dp)
            )
            Image(painter = painterResource(id = R.drawable.hard_btn), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable { navController.navigate("question_screen/hard")}
                    .height(80.dp)
                    .width(200.dp)
            )
        }
    }
}