package com.example.mangaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mangaapp.ui.theme.MangaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MangaAppTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(R.color.Jet_black)),
                    verticalArrangement = Arrangement.Center
                ) {
                    SignIn("", "")

                }
            }
        }
    }
}

@Composable
fun SignIn(email: String, passwd: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(2))
            .background(color = colorResource(R.color.dark_grey)),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .padding(30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Zenithra", color = colorResource(R.color.white), style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(300),
                )
            )
            Text(
                "Welcome Back", color = colorResource(R.color.white), style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight(400),
                ), modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                "Please enter your details to sign in",
                color = colorResource(R.color.white),
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(100)
                ),
                modifier = Modifier.padding(top = 10.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp).padding(horizontal = 100.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.then(Modifier.size(40.dp))
                        .border(0.5.dp, Color.White, shape = CircleShape)
                        .padding(10.dp)
                ) {
                    Image(
                        painterResource(R.drawable.googleicon),
                        "Google Icon",
                        modifier = Modifier.width(30.dp)
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier.then(Modifier.size(40.dp))
                        .border(0.5.dp, Color.White, shape = CircleShape)
                        .padding(10.dp)
                ) {
                    Image(
                        painterResource(R.drawable.appleicon),
                        "Google Icon",
                        modifier = Modifier.width(30.dp)
                    )
                }
            }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    HorizontalDivider(modifier = Modifier.width(150.dp), thickness = 0.2.dp)
                    Text(
                        " OR ", color = colorResource(R.color.white), style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(200),
                        )
                    )
                    HorizontalDivider(modifier = Modifier.width(150.dp), thickness = 0.2.dp)
                }
                OutlinedTextField(
                    email,
                    onValueChange = {},
                    placeholder = { Text("Enter Email Address",  color = Color.White) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                )
                OutlinedTextField(
                    value = passwd,
                    onValueChange = {},
                    placeholder = { Text("Password", color = Color.White) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                )
                Text(
                    "Forgot password?", modifier = Modifier
                        .padding(top = 10.dp)
                        .clickable { }, color = colorResource(R.color.purple_700)
                )
                Button(
                    onClick = {},
                    enabled = false,
                    colors = ButtonColors(
                        containerColor = colorResource(R.color.black),
                        contentColor = colorResource(R.color.white),
                        disabledContentColor = colorResource(R.color.disabled_grey),
                        disabledContainerColor = colorResource(R.color.dull_grey)
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Text("Sign In")
                }
            Text("Don't have an account? Sign Up")
            }
        }
    }

