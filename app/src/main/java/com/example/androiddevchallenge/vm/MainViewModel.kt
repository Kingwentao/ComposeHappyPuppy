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
package com.example.androiddevchallenge.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Puppy


class MainViewModel : ViewModel() {
    val puppyList by mutableStateOf(
        listOf(
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
            ),
            Puppy(
                "Hanhan", "Chihuahua Mix",
                "Chihuahuas are small in stature and do not require high living space. Basically, the space of a normal residence is enough for them to play.",
                "3", "Female", "Small", R.drawable.puppy_jiwawa_hanhan
            ),
            Puppy(
                "Buduo", "Mountain Puppy & Shepherd Mix",
                "The Labrador is an almost perfect dog, with a strong but not obese body, and a very cute appearance.It also has the top five IQ, it is easy to train, and it learns to follow orders the fastest.",
                "Puppy", "Female", "Medium", R.drawable.puppy_labuladuo_buduo
            ),
            Puppy(
                "Congcong", "Mountain Puppy & Shepherd Mix",
                "Bianmu is the dog with the highest IQ. The most distinguishing feature is intelligence, strong learning ability, high comprehension, easy training, gentleness, loyalty, and obedience.",
                "Puppy", "Male", "Big", R.drawable.puppy_bianjingmuyangquan_congcong
            ),
        )
    )

    var currentPuppy: Puppy? by mutableStateOf(null)

    fun showPuppy(Puppy: Puppy) {
        currentPuppy = Puppy
    }

    fun closePuppy() {
        currentPuppy = null
    }
}
