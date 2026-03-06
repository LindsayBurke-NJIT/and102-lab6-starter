package com.codepath.lab6

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class ParksResponse(
    @SerialName("data")
    val data: List<Park>?
)

@Keep
@Serializable
@Parcelize
data class Park(
    @SerialName("fullName")
    val fullName: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("images")
    val images: List<ParkImage>?
) : Parcelable {
    val imageUrl: String?
        get() = images?.firstOrNull()?.url
}

@Keep
@Serializable
@Parcelize
data class ParkImage(
    @SerialName("url")
    val url: String?
) : Parcelable
