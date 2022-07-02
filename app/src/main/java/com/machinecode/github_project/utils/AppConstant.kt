package com.machinecode.github_project.utils

import android.annotation.SuppressLint
import android.content.Context
import android.text.format.DateFormat
import android.util.Log
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import com.google.gson.Gson
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat

/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
object AppConstant {

    @SuppressLint("SimpleDateFormat")
    fun getSortDataTime(strDate: String): String {
        return DateFormat.format(
            "MM-dd-yy hh:mm",
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(strDate)
        ).toString()
    }

    fun getJsonStringToObject(myObj: Any): String {
        val gson = Gson()
        Log.e("", "getJsonStringToObject: " + gson.toJson(myObj))
        return gson.toJson(myObj)
    }

    fun getObjectFromJson(s: String, anyObject: Any): Any {
        return Gson().fromJson(s, anyObject::class.java)
    }

    fun loadImage(imageUrl: String?, imageId: ImageView) {
        if (imageUrl != null) {
            try {
                Picasso.get().load(imageUrl)
                    .networkPolicy(NetworkPolicy.NO_STORE, NetworkPolicy.NO_CACHE).into(imageId)
            } catch (ex: Exception) {
            }
        } else {
            Picasso.get().load("")
                .networkPolicy(NetworkPolicy.NO_STORE, NetworkPolicy.NO_CACHE).into(imageId)
        }
    }

    fun createCheckBox(
        context: Context?,
        textValue: String?,
        id: Int,
        isChecked: Boolean
    ): CheckBox {
        val cb = CheckBox(context)
        cb.text = textValue
        cb.id = id
        cb.isChecked = isChecked
        return cb
    }

    fun createRadioButton(
        context: Context?,
        textValue: String?,
        id: Int,
        isChecked: Boolean
    ): RadioButton {
        val cb = RadioButton(context)
        cb.text = textValue
        cb.id = id
        cb.isChecked = isChecked
        return cb
    }
}