package com.danywizzy.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.danywizzy.recyclerview.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var imageAdapter: ImageAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = binding.recyclerView
        imageAdapter = ImageAdapter(ListData.createDataSet())

        val numberOfColumns = 10;
        val gridLayoutManager =
            object : GridLayoutManager(this, numberOfColumns, HORIZONTAL, false) {
                override fun checkLayoutParams(layoutParams: RecyclerView.LayoutParams): Boolean {
                    layoutParams.width = width / 7
                    return true
                }
            }
        with(recyclerView) {
            setHasFixedSize(true)
            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(this)
            layoutManager = gridLayoutManager
            adapter = imageAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_image -> {
                ListData.addImage()
                true
            }
            R.id.reload_all -> {
                ListData.reloadAll()
                imageAdapter.notifyDataSetChanged()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}