package com.example.portofoliomahasiswa

import android.os.Parcel
import android.os.Parcelable



data class Portofolio(
    var nama: String?,
    var username: String?,
    var avatar: String?,
    var follower: String?,
    var following: String?,
    var company: String?,
    var location: String?,
    var repository: String?

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeString(username)
        parcel.writeString(avatar)
        parcel.writeString(follower)
        parcel.writeString(following)
        parcel.writeString(company)
        parcel.writeString(location)
        parcel.writeString(repository)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Portofolio> {
        override fun createFromParcel(parcel: Parcel): Portofolio {
            return Portofolio(parcel)
        }

        override fun newArray(size: Int): Array<Portofolio?> {
            return arrayOfNulls(size)
        }
    }
}
