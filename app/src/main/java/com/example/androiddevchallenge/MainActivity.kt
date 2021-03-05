/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.extensions.drawColoredShadow
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme(darkTheme = true) {
                MyApp()
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MyApp(viewModel: MainViewModel = viewModel()) {
    val days: String by viewModel.days.observeAsState(initial = "0")
    val hours: String by viewModel.hours.observeAsState(initial = "0")
    val minutes: String by viewModel.minutes.observeAsState(initial = "0")
    val seconds: String by viewModel.seconds.observeAsState(initial = "0")

    Surface(color = Color(0xF0000000)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Text(
                    text = "COUNTDOWN TO HER BIRTHDAY",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Color.White,
                    modifier = Modifier
                        .drawColoredShadow(
                            color = Color(65, 120, 255),
                            alpha = 0.12f,
                            shadowRadius = 32.dp
                        )
                        .drawColoredShadow(
                            color = Color(192, 219, 255),
                            alpha = 0.48f,
                            shadowRadius = 80.dp
                        )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 60.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CountItem(text = days, description = "DAYS")
                CountItem(text = hours, description = "HOURS")
                CountItem(text = minutes, description = "MINUTES")
                CountItem(text = seconds, description = "SECONDS")
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun CountItem(text: String, description: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .drawColoredShadow(
                color = Color(65, 120, 255),
                alpha = 0.12f,
                shadowRadius = 30.dp
            )
            .drawColoredShadow(
                color = Color(192, 219, 255),
                alpha = 0.48f,
                shadowRadius = 60.dp
            )
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight(800),
            modifier = Modifier
                .animateContentSize()
        )
        Text(text = description, color = Color(0x99FFFFFF), fontSize = 10.sp)
    }
}
