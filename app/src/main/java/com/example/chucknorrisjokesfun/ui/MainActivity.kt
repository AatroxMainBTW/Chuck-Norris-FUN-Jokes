package com.example.chucknorrisjokesfun.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokesfun.R
import com.example.chucknorrisjokesfun.repository.Repository
import com.example.chucknorrisjokesfun.viewmodel.MainViewModel
import com.example.chucknorrisjokesfun.viewmodel.MainViewModelFactory
import okhttp3.*


class MainActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    lateinit var viewModel:MainViewModel
    var btn:Button? = null
    var tv:TextView? = null
    var iv:ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btnJoke)
        tv = findViewById(R.id.tvJoke)
        iv = findViewById(R.id.ivJoke)


        btn?.setOnClickListener {
            val repository= Repository()
            val viewModelFactory =  MainViewModelFactory(repository)
            viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
            viewModel.getJokesFromAPI()
            viewModel.myResponse.observe(this, Observer { response ->

                tv?.setText(response.value)
                //val imageUrl = response.icon_url.toString()
                //var image: Bitmap? = null
                //val im = java.net.URL(imageUrl).openStream()
                //image = BitmapFactory.decodeStream(im)
                //iv?.setImageBitmap(image)


            })
        }


    }







}