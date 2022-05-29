package com.example.challegevideoalkemy.ui.adapter


import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.challegevideoalkemy.R
import com.example.challegevideoalkemy.data.retrofit.Constants.Companion.IMG_API_PATH
import com.example.challegevideoalkemy.databinding.ItemCardBinding
import com.example.challegevideoalkemy.domain.model.Movie

import com.squareup.picasso.Picasso

class MovieAdapter(
    var movieList: MutableList<Movie>,
) :
    RecyclerView.Adapter<MovieAdapter.MyMovieViewHolder>() {


    override fun getItemCount(): Int = movieList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMovieViewHolder {
        val movieBinding =
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyMovieViewHolder(movieBinding)
    }

    override fun onBindViewHolder(holder: MyMovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.txtTitle.text = movie.title
        Picasso.get()
            .load("${IMG_API_PATH}${movie.image}")
            .placeholder(R.color.purple_200)
            .into(holder.binding.imageView)


    }

    class MyMovieViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)


}





