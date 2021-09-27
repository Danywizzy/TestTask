package com.danywizzy.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.danywizzy.recyclerview.data.Image

class ImageDiffUtils(
    private val oldList: List<Image>,
    private val newList: List<Image>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldId = oldList[oldItemPosition].id
        val newId = newList[newItemPosition].id
        return oldId == newId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldImage = oldList[oldItemPosition]
        val newImage = newList[newItemPosition]
        val oldUrl = oldImage.url
        val newUrl = newImage.url
        return oldUrl == newUrl
    }
}