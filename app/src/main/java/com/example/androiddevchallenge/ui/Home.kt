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

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.vm.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun Home() {
    val snackbarHostState = SnackbarHostState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Puppy Park")
                }
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) {
        val viewModel: MainViewModel = viewModel()
        PuppyList(
            viewModel.puppyList,
            { puppy ->
                viewModel.showPuppy(puppy)
            },
            { puppy ->
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Thanks for you have adopted me,i am ${puppy.name}")
                }
            }
        )

        val puppy = viewModel.currentPuppy
        if (puppy != null) {
            PuppyDetails(puppy) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Thanks for you have adopted me,i am ${puppy.name}")
                }
            }
        }
    }
}
