package com.example.fragmentexample

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
//classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version" at least 1.4.20

@Parcelize
data class Person(val name: String, val age: Int): Parcelable

