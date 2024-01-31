package com.example.businesscard

import android.os.Bundle
import android.provider.ContactsContract.Contacts
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun TitleText(
    name: String,
    position: String,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
    ){
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = position,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            color = Color(red = 6, green = 146, blue = 25, alpha = 255)
        )
    }
    
}

@Composable
fun Title() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        var image = painterResource(R.drawable.android_logo)
        Surface(
            color = Color(red = 11, green = 48, blue = 71),
            modifier = Modifier.width(200.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null
            )
        }
        TitleText(
            name = stringResource(R.string.name),
            position = stringResource(R.string.position)
        )
    }
}

@Composable
fun Contact(icon: Painter, text: String, modifier: Modifier = Modifier) {
    Row (
        modifier.padding(4.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color(red = 6, green = 146, blue = 25, alpha = 255)
        )
        Text(
            text = text
        )
    }
}

@Composable
fun Contacts() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        Column (

        ) {
            Contact(
                icon = painterResource(R.drawable.baseline_phone_24),
                text = "+00 (00) 000 000"
            )
            Contact(
                icon = painterResource(R.drawable.baseline_bubble_chart_24),
                text = "@socialmediahandle"
            )
            Contact(
                icon = painterResource(R.drawable.baseline_alternate_email_24),
                text = "email@gmail.com"
            )
        }
    }

}

@Composable
fun App() {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color(red = 212, green = 252, blue = 217)
    ) {
        Title()
        Contacts()
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        App()
    }
}