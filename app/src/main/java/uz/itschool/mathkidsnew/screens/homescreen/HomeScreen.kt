package uz.itschool.mathkidsnew.screens.homescreen

import android.os.Build
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import kotlinx.coroutines.delay
import uz.itschool.mathkidsnew.R
import uz.itschool.mathkidsnew.screens.splashscreen.ImageExample

@Composable
fun HomeScreen(navController: NavController) {
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
            Image(
                painter = painterResource(id = R.drawable.play_btn), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable { navController.navigate("menu_screen") }
                    .height(80.dp)
                    .width(200.dp)
            )
            Image(painter = painterResource(id = R.drawable.records_btn), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable { navController.navigate("results_screen") }
                    .height(80.dp)
                    .width(200.dp)
            )
        }
    }
}

@Composable
fun ImageExample() {
    Image(
        painter = rememberAsyncImagePainter(R.drawable.img_bg_main),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}