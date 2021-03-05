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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.extensions.days
import com.example.androiddevchallenge.extensions.hours
import com.example.androiddevchallenge.extensions.minutes
import com.example.androiddevchallenge.extensions.seconds
import java.util.Calendar
import java.util.Timer
import java.util.TimerTask
import kotlin.math.roundToInt

class MainViewModel : ViewModel() {
    companion object {
        const val COUNTDOWN_INTERVAL = 1000L
    }

    private val birthDay = Calendar.getInstance().apply {
        set(Calendar.MONTH, Calendar.MARCH)
        set(Calendar.DAY_OF_MONTH, 18)
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
    }
    private val _days = MutableLiveData("0")
    private val _daysChanged = MutableLiveData(false)
    private val _hours = MutableLiveData("0")
    private val _minutes = MutableLiveData("0")
    private val _seconds = MutableLiveData("0")

    val days: LiveData<String> = _days
    val daysChanged: LiveData<Boolean> = _daysChanged
    val hours: LiveData<String> = _hours
    val minutes: LiveData<String> = _minutes
    val seconds: LiveData<String> = _seconds

    init {
        val timerTask = object : TimerTask() {
            override fun run() {
                val interval = birthDay.timeInMillis - System.currentTimeMillis()
                _days.postValue(interval.days().roundToInt().toString())
                _daysChanged.postValue(true)
                _hours.postValue(interval.hours().roundToInt().toString())
                _minutes.postValue(interval.minutes().roundToInt().toString())
                _seconds.postValue(interval.seconds().roundToInt().toString())
            }
        }
        Timer().schedule(timerTask, 0, COUNTDOWN_INTERVAL)
    }
}
