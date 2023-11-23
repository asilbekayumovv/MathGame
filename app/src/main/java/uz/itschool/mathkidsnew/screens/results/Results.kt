package uz.itschool.mathkidsnew.screens.results

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.mathkidsnew.MySharedPreferences
import uz.itschool.mathkidsnew.R

@Composable
fun Results(navController: NavController){
    val sharedPreferences = MySharedPreferences.getInstance(LocalContext.current)
    Box(
        modifier = with(Modifier) {
            fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.img_bg_main),
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
            Row {
                Text(text = "Easy mode: ", color = Color.White, fontSize = 45.sp)
                Text(text = sharedPreferences.getData("easy").toString(), color = Color.White, fontSize = 45.sp)
            }
            Row {
                Text(text = "Normal mode: ", color = Color.White, fontSize = 45.sp)
                Text(text = sharedPreferences.getData("normal").toString(), color = Color.White, fontSize = 45.sp)
            }
            Row {
                Text(text = "Hard mode: ", color = Color.White, fontSize = 45.sp)
                Text(text = sharedPreferences.getData("hard").toString(), color = Color.White, fontSize = 45.sp)
            }
        }
    }
}