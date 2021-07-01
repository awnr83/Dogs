package com.example.dogs.dogsList

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.R
import com.example.dogs.convertStringImage
import com.example.dogs.databinding.ListDogBinding
import com.example.dogs.dogsList.DogsAdapter.ViewHolder.Companion.from
import androidx.recyclerview.widget.ListAdapter

class DogsAdapter(val clickListener: DogListener): ListAdapter<String, DogsAdapter.ViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsAdapter.ViewHolder {
        return from(parent)
    }
    override fun onBindViewHolder(holder: DogsAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class ViewHolder private constructor(val binding:ListDogBinding): RecyclerView.ViewHolder(binding.root) {
        //private val binding= ListDogBinding.bind(view)
        val img= binding.img

        fun bind(item: String, clickListener: DogListener){
            binding.dog=item
            binding.clickListener=clickListener
            //convertStringImage(binding.img, item)
        }
        companion object{
            fun from(parent: ViewGroup):ViewHolder{
                val layoutInflater= LayoutInflater.from(parent.context)
                val binding= ListDogBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}
class DiffCallBack:DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem===newItem
    }
    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem.equals(newItem)
    }
}

class DogListener(val clickListener: (url: String)->Unit){
    fun onClick(img: String)= clickListener(img)
}