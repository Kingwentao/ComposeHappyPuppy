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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.buttonColor

@Composable
fun PuppyDetails(puppy: Puppy, onAdopt: (Puppy) -> Unit = {}) {
    Column(
        Modifier
            .fillMaxSize()
            .background(buttonColor)
    ) {
        Box {
            Image(
                painterResource(puppy.picture),
                "Puppy Name: ${puppy.name}",
                Modifier.aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Button(
                { onAdopt(puppy) },
                Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(buttonColor)
            ) {
                Text(text = "Adopt Me")
            }
        }
        Column(Modifier.padding(16.dp, 8.dp)) {
            Text("Name: ${puppy.name}", style = MaterialTheme.typography.h3)
            ProvideTextStyle(MaterialTheme.typography.h5) {
                Text("Breed: ${puppy.breed}")
                Text("Age: ${puppy.age}")
                Text("Gender: ${puppy.gender}")
                Text("Size: ${puppy.size}")
                Text("Me: ${puppy.description}", maxLines = 4,fontSize = 16.sp)
            }
        }
    }
}

@Preview
@Composable
fun PuppyDetailPreview() {
    PuppyDetails(
        Puppy(
            "Keke", "Pit Bull Terrier Mix",
            "Corgis have short hair and are easy to take care of, and they are not large in size, so the cost of breeding is not very high.",
            "3", "Female", "Small", R.drawable.puppy_keji_keke
        )
    )
}
