package com.example.e_patrakaar.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
class Collection(
    val title: String? = null,
    val description: String? = null,
    var image: @RawValue Any? = null,
    val author: String? = null,
    val content: String? = null,
    val publishedAt: String? = null,
    val url: String? = null
) : Parcelable