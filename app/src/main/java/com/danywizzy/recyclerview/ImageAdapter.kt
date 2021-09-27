package com.danywizzy.recyclerview

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.bumptech.glide.signature.ObjectKey
import com.danywizzy.recyclerview.data.Image
import com.danywizzy.recyclerview.databinding.RecyclerviewItemBinding

class ImageAdapter ( private val imageList: ArrayList<Image>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(private val view: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        private val imageView = view.imageView
        private val progressBar = view.progressBar

        fun bind(image: Image) {
            progressBar.visibility = View.VISIBLE
            Glide.with(imageView.context)
                .load(image.url)
                .centerCrop()
                .signature(ObjectKey(System.currentTimeMillis().toString()))
                .into(object : CustomTarget<Drawable>() {
                    override fun onLoadCleared(placeholder: Drawable?) {
                    }

                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable>?
                    ) {
                        imageView.setImageDrawable(resource)
                        progressBar.visibility = View.GONE
                    }
                })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = RecyclerviewItemBinding.inflate(layoutInflater, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    fun setData(newList: List<Image>){
        imageList.clear()
        imageList.addAll(newList)
    }
}
