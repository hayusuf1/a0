package com.example.assignment0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment0.ui.theme.Assignment0Theme
import kotlin.random.Random


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment0Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ButtonHandler(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }

            }
        }
    }

@Composable
fun ButtonHandler(
    modifier: Modifier = Modifier
){
    var showYes by remember  { mutableStateOf(false) }
    var showMeh by remember  { mutableStateOf(false) }
    var showNo by remember  { mutableStateOf(false) }
    var counter1 by remember { mutableStateOf(0) }
    var counter2 by remember { mutableStateOf(0) }
    var counter3 by remember { mutableStateOf(0) }


    Column() {

        Text(
            text = "Name: Hamse Yusuf" +
                    " CCID:hamse1",
            modifier.padding(20.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
            )


        Text(
            text = "Should I go?",
            modifier.padding(20.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
                ,

        )

        Row(modifier.fillMaxWidth()) {
            if (showYes){
                Text(
                    text = "Yes!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            if (showMeh){
                Text(
                    text = "Yes!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            if (showNo){
                Text(
                    text = "Yes!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }

    Row(modifier.padding(56.dp).fillMaxWidth()) {


        Button(
            onClick = {

                counter1++
                showYes = if (Random.nextDouble() <= 0.5){
                    true
                } else{
                    false
                }

                showMeh = false
                showNo = false

            }
        ) {Text("Yes!") }



        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {

                counter2++
                showMeh = if (Random.nextDouble() <= 0.25){
                    true
                } else{
                    false
                }


                showYes = false
                showNo = false
            }
        ) { Text("Meh!")}

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {

                counter3++
                showNo = if(Random.nextDouble() <=0.10){
                    true
                } else{
                    false
                }


                showMeh = false
                showYes = false
            }
        ) { Text("No!")}
    }

    Row() {

        Text(
            text = "Clicks: $counter1",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Clicks: $counter2",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Clicks: $counter3",
            fontWeight = FontWeight.Bold
        )

    }
    }
}