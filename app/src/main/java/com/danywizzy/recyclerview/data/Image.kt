package com.danywizzy.recyclerview.data

import java.util.*

data class Image(
    val id: String = UUID.randomUUID().toString(),
    val url: String = "https://loremflickr.com/200/200/",
    val imageState: ImageState = ImageState.EMPTY
) {
    enum class ImageState {
        EMPTY, DOWNLOAD, DOWNLOADED
    }
}