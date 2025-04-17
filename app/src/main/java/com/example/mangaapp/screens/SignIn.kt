package com.example.mangaapp.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mangaapp.R
import com.example.mangaapp.viewmodels.UserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(navController: NavController, userViewModel: UserViewModel, email: String, paswd: String, changeEmail : (String) -> Unit, changePaswd: (String) -> Unit) {
    val context = LocalContext.current
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .padding(horizontal = 100.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .then(Modifier.size(40.dp))
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
                    modifier = Modifier
                        .then(Modifier.size(40.dp))
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
                onValueChange = { changeEmail(it) },
                placeholder = { Text("Enter Email Address",  color = Color.Gray) },
                colors = TextFieldDefaults.textFieldColors(focusedTextColor = Color.White, containerColor = Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .border(
                        color = Color.Gray,
                        width = 0.5.dp,
                        shape = RoundedCornerShape(3.dp)
                    )
            )
            OutlinedTextField(
                value = paswd,
                onValueChange = {changePaswd(it)},
                placeholder = { Text("Password", color = Color.Gray) },
                colors = TextFieldDefaults.textFieldColors(focusedTextColor = Color.White, containerColor = Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .border(
                        color = Color.Gray,
                        width = 0.5.dp,
                        shape = RoundedCornerShape(5.dp)
                    ),
            )
            Text(
                "Forgot password?", modifier = Modifier
                    .padding(top = 10.dp)
                    .clickable { }, color = colorResource(R.color.purple_700)
            )
            Button(
                onClick = {
//                        lifecycleScope.launch{ userViewModel.login(email, paswd) }
                    if (email == "abc@gmail.com" && paswd == "abc") {
                        navController.navigate("Home Screen")
                    } else {
                        Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                },
                enabled = email!="" && paswd!="",
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

