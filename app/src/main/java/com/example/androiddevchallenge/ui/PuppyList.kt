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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.buttonColor

@Composable
fun PuppyList(
    puppyList: List<Puppy>, onPuppyClick: (Puppy) -> Unit = {},
    onAdopt: (Puppy) -> Unit = {}
) {
    LazyColumn(
        Modifier.background(MaterialTheme.colors.onBackground),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(puppyList) {
            PuppyItem(
                it,
                Modifier
                    .clickable {
                        onPuppyClick(it)
                    }
                    .fillMaxWidth(), onAdopt
            )
        }
    }
}

@Composable
fun PuppyItem(
    puppy: Puppy, modifier: Modifier = Modifier,
    onAdopt: (Puppy) -> Unit = {}
) {
    Card(modifier) {
        Row {
            Column(
                Modifier
                    .width(120.dp)
                    .padding(start = 5.dp)) {
                Text(puppy.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("Breed:" + puppy.breed, fontSize = 12.sp)
                Text("Age:" + puppy.age, fontSize = 12.sp)
                Button(
                    onClick = {
                        onAdopt(puppy)
                    },
                    Modifier
                        .padding(top = 20.dp),
                    shape = MaterialTheme.shapes.large,
                    colors = ButtonDefaults.buttonColors(buttonColor)
                ) {
                    Text(text = "Adopt Me", fontSize = 10.sp)
                }
            }
            Image(
                painterResource(puppy.picture),
                "puppy name: ${puppy.name}",
                Modifier.size(180.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun PuppyListPreview() {
    val puppyList = listOf(
        Puppy(
            "Keke", "Pit Bull Terrier Mix",
            "Corgis have short hair and are easy to take care of, and they are not large in size, so the cost of breeding is not very high.",
            "3", "Female", "Small", R.drawable.puppy_keji_keke
        ),
        Puppy(
            "Nana", "Terrier Mix",
            "Schnauzer is known as \"the dog of the apartment\", very suitable for urban office workers. The biggest advantage of this kind of dog is that it doesn't shed much hair, and the taste is very small, lazy people prefer it.",
            "5", "Female", "Medium", R.drawable.puppy_xueruina_nana
        ),
        Puppy(
            "Midu", "American Staffordshire Terrier Mix",
            "Miniature Pinscher looks like a deer, so it is also called a deer dog. The hair is short, so it is easier to clean up,He is also a sports expert, has a high degree of training, is naturally intelligent, and is easy to raise.",
            "2", "Male", "Small", R.drawable.puppy_minidubin_midu
        )
    )
    MyTheme {
        PuppyList(puppyList)
    }
}

@Preview
@Composable
fun PuppyListPreviewDark() {
    val puppyList = listOf(
        Puppy(
            "Keke", "Pit Bull Terrier Mix",
            "Corgis have short hair and are easy to take care of, and they are not large in size, so the cost of breeding is not very high.",
            "3", "Female", "Small", R.drawable.puppy_keji_keke
        ),
        Puppy(
            "Nana", "Terrier Mix",
            "Schnauzer is known as \"the dog of the apartment\", very suitable for urban office workers. The biggest advantage of this kind of dog is that it doesn't shed much hair, and the taste is very small, lazy people prefer it.",
            "5", "Female", "Medium", R.drawable.puppy_xueruina_nana
        ),
        Puppy(
            "Midu", "American Staffordshire Terrier Mix",
            "Miniature Pinscher looks like a deer, so it is also called a deer dog. The hair is short, so it is easier to clean up,He is also a sports expert, has a high degree of training, is naturally intelligent, and is easy to raise.",
            "2", "Male", "Small", R.drawable.puppy_minidubin_midu
        )
    )
    MyTheme(darkTheme = true) {
        PuppyList(puppyList)
    }
}

@Preview
@Composable
fun PuppyItemPreview() {
    MyTheme {
        Puppy(
            "Keke", "Pit Bull Terrier Mix",
            "Corgis have short hair and are easy to take care of, and they are not large in size, so the cost of breeding is not very high.",
            "3", "Female", "Small", R.drawable.puppy_keji_keke
        )
    }
}

@Preview
@Composable
fun PuppyItemPreviewDark() {
    MyTheme(darkTheme = true) {
        Puppy(
            "Keke", "Pit Bull Terrier Mix",
            "Corgis have short hair and are easy to take care of, and they are not large in size, so the cost of breeding is not very high.",
            "3", "Female", "Small", R.drawable.puppy_keji_keke
        )
    }
}
