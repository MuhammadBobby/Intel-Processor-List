package com.dicoding.intelprocessorlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Intel(
    val title: String,
    val description: String,
    val image: String,
    val price: String
): Parcelable
