package com.jkl.wwtestapp.main.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ConfigData(
    private val status: Boolean,
    private val link: String
) : Parcelable {
    interface Mapper<T> {
        fun map(status: Boolean, link: String): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(status, link)

    fun link() = link

    override fun toString(): String {
        return "{ status: $status, " +
                "link: \"$link\" }"
    }
}