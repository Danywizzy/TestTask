package com.danywizzy.recyclerview

import com.danywizzy.recyclerview.data.Image

class ListData {

    companion object {
        private var imageList = arrayListOf<Image>()

        fun createDataSet() : ArrayList<Image> {
            var i = 0
            while (i < 140) {
                imageList.add(Image())
                i++
            }
            return imageList
        }

        fun addImage() {
            imageList.add(Image())
        }

        fun reloadAll() {
            imageList.clear()
            var i = 0
            while (i < 140) {
                imageList.add(Image())
                i++
            }
        }
    }
}