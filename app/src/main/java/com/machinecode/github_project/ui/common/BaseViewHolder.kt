package com.machinecode.github_project.ui.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Author: Rezaul Khan
 * github: https://github.com/rezaulkhan111
 */
open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var mCurrentPosition = 0
    open fun onBind(position: Int) {
        mCurrentPosition = position
    }
}