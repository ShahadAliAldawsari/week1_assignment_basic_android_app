package com.example.week1assignmentbasicandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week1assignmentbasicandroidapp.ui.theme.Week1AssignmentBasicAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(true) }
            Week1AssignmentBasicAndroidAppTheme(darkTheme = isDarkTheme) {
                FilmPage(isDarkTheme) { isDarkTheme = !isDarkTheme }
//                FilmPage()
            }
        }
    }

}



@Composable
fun FilmPage(isDarkTheme: Boolean, onThemeToggle: () -> Unit) {

    Card (
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 32.dp, 0.dp, 16.dp)
//            .background(MaterialTheme.colorScheme.surface),
        ,colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(0)// 0 to get sharp corners

        ){

        //Light Mode and Dark Mode button
        Button(
            onClick = onThemeToggle,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.sunmoon2),
                contentDescription = "Sun moon icon",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
        }
        //Film image
        Image(
            painter = painterResource(id = R.drawable.movie_image),
            contentDescription = "Image of the wild robot movie",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )


        //Adding a space
        Spacer(modifier = Modifier.height(16.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth()
//                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),

        ){

            //Film Name
            Text(
                text = "The Wild Robot",
                fontSize = 32.sp,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onBackground
            )

            //Film year and resolution
            Row (
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Text(text = "2024", color = MaterialTheme.colorScheme.onBackground, fontSize = 20.sp)
                Text(text = " 720p ", color = MaterialTheme.colorScheme.surface, fontSize = 12.sp, modifier = Modifier.background(Color.Gray))
                Text(text = " 1080p ", color = MaterialTheme.colorScheme.surface, fontSize = 12.sp, modifier = Modifier.background(Color.Gray))

            }

            //Play and download buttons
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp, 0.dp, 32.dp, 0.dp),
//                    .background(Color.DarkGray) //I don't need it if the BG color is the same
//                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ){
                //1- Play button
                Button(onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground),
                    shape = RoundedCornerShape(0)// 0 to get sharp corners
                    ) {
                    Row () {
                        Icon( //I'm using icon instead of image so I can change its color using "tint"
                            painter = painterResource(id=R.drawable.play),
                            contentDescription = "Play icon",
                            modifier = Modifier
//                                .fillMaxWidth()
                                .height(18.dp)
                                .width(18.dp),
                            tint = MaterialTheme.colorScheme.background
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(text = "Play",
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.background
                        )
                    }
                }
                //2- Download button
                Button(onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground),
                    shape = RoundedCornerShape(0)// 0 to get sharp corners
                    ) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.download),
                            contentDescription = "Download icon",
                            modifier = Modifier
                                .height(18.dp)
                                .width(18.dp),
                            tint = MaterialTheme.colorScheme.background
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "Download",
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.background
                        )
                    }
                }

            }

            //Film description
            Text(
                modifier = Modifier,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                text = "After a shipwreck, an intelligent robot is stranded on an uninhabited island. " +
                        "To survive the harsh surroundings, she bonds with the native animals and cares for an orphaned baby goose.",

            )

            //Watch list button
            var inTheList by remember { mutableStateOf(false) }
            Button(onClick = {
                inTheList = !inTheList
            },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background)
            ) {

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
                ){
                    var id = R.drawable.plus
                    var text = "Watch List"
                    if (inTheList) {
                        id = R.drawable.cross
                        text = "Remove"
                    }
                    //The + or x icon
                    Icon(
                        painter = painterResource(id = id),
                        contentDescription = "a + icon",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .height(36.dp)
                            .width(36.dp)
                    )
                    Spacer(Modifier.height(8.dp))
                    //Text "Watch List"
                    Text(
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        text = text
                    )
                    Spacer(Modifier.height(100.dp)) //It's not the best way but i'm still learning
                }
            }
        }

        //Bottom Navigation Bar
        Row(
                        modifier = Modifier
                            .padding(0.dp, 8.dp, 0.dp, 16.dp)
                            .fillMaxSize(),
            //                .padding(0.dp)
//            verticalAlignment = Alignment.Bottom
        ) {
            val iconHeight = 20.dp
            val iconWidth = 20.dp
            val font_size = 15.sp
            //browse
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface),
//                modifier = Modifier.width(iconWidth)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    //Menu burger icon
                    Icon(
                        painter = painterResource(id = R.drawable.menu_burger),
                        contentDescription = "Menu burger icon",
                        modifier = Modifier
                            .height(iconHeight)
                            .width(iconWidth),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(Modifier.height(8.dp))
                    //Menu burger icon name
                    Text(
                        text = "Browse",
                        fontSize = font_size,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                }
            }
            //watchlist
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface),
                //                modifier = Modifier.width(iconWidth_)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    //watch icon
                    Icon(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = "watch icon",
                        tint =MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .height(iconHeight)
                            .width(iconWidth)
                    )
                    Spacer(Modifier.height(8.dp))
                    //watch icon name
                    Text(
                        text = "Watch",
                        fontSize = font_size,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            //downloads
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface),
                //                modifier = Modifier.width(iconWidth_)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //downloads icon
                    Icon(
                        painter = painterResource(id = R.drawable.download),
                        contentDescription = "downloads icon",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .height(iconHeight)
                            .width(iconWidth)
                    )
                    Spacer(Modifier.height(8.dp))
                    //downloads icon name
                    Text(
                        text = "Downloads",
                        fontSize = font_size,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            //search
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface),
//                                modifier = Modifier.width(120.dp)
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                        ){
                    //search icon
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "search icon",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .height(iconHeight)
                            .width(iconWidth)
                    )
                    Spacer(Modifier.height(8.dp))
                    //search icon name
                    Text(
                        text = "Search",
                        fontSize = font_size,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}
