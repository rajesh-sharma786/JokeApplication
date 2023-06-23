package com.example.jokeapplication.adapters

import android.graphics.Color
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jokeapplication.R

class JokeAdapter(var jokes: List<String>) : RecyclerView.Adapter<JokeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView: View = inflater.inflate(R.layout.joke_info_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(jokes[position])
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mJokeText: TextView
        private val separatorView:View

        init {
            mJokeText = itemView.findViewById(R.id.joke_tv)
            separatorView = itemView.findViewById(R.id.separator_view)
            separatorView.setBackgroundColor(Color.parseColor("#000000"))
        }

        fun setData(joke: String?) {
            val pos = adapterPosition
            if (pos >= 0 && pos < jokes.size) {
                if (!TextUtils.isEmpty(joke)) {
                    mJokeText.text = joke
                }
            }
        }
    }
}