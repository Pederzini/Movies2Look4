package com.example.movies2look4.extensions

import com.example.movies2look4.network.IMG_BASE_URL

fun String.toImageUrl() = "${IMG_BASE_URL}${this}"