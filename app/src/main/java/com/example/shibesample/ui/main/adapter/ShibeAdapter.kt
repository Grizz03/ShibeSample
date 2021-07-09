package com.example.shibesample.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shibesample.databinding.ShibeItemBinding
import com.example.shibesample.utils.loadImage

class ShibeAdapter(private val urls: List<String>) : RecyclerView.Adapter<ShibeAdapter.ShibeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShibeViewHolder {
        return ShibeViewHolder(
            ShibeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ShibeViewHolder, position: Int) {
        holder.bind(urls[position])
    }

    override fun getItemCount(): Int {
        return urls.size
    }

    class ShibeViewHolder(private val binding: ShibeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String) {
            with(binding) {
                shibeImage.loadImage(url)
            }
        }
    }
}