package com.nightlaro.listmaker

import android.os.Parcel
import android.os.Parcelable

class Tasklist(val name: String,
               val tasks: MutableList<String> = mutableListOf()): Parcelable {
    //no clue what this parcel thing is doing at this moment
    constructor(parcel: Parcel) : this( //what?
        parcel.readString()!!,
        parcel.createStringArrayList()!!
    )

    companion object CREATOR: Parcelable.Creator<Tasklist> {
        override fun createFromParcel(source: Parcel): Tasklist = Tasklist(source) // where did source come from?

        override fun newArray(size: Int): Array<Tasklist?> = arrayOfNulls(size)

    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeStringList(tasks)
    }
    override fun describeContents() = 0 //will only be >=one if dealing with file descriptors, according to tut

}