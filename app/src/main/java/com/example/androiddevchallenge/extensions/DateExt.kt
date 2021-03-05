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
package com.example.androiddevchallenge.extensions

import kotlin.math.floor

/**
 * Extension method to provide Date remaining calculate functions.
 */
fun Long.remainingDays() = floor((this / (24 * 3600 * 1000)).toDouble())
fun Long.remainingHours() = floor((this % (24 * 3600 * 1000) / (3600 * 1000)).toDouble())
fun Long.remainingMinutes() =
    floor(((this % (24 * 3600 * 1000) % (3600 * 1000)) / (60 * 1000)).toDouble())

fun Long.remainingSeconds() =
    floor((((this % (24 * 3600 * 1000) % (3600 * 1000)) % (60 * 1000)) / 1000).toDouble())
