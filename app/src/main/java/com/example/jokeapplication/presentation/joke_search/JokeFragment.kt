package com.example.jokeapplication.presentation.joke_search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jokeapplication.R
import com.example.jokeapplication.adapters.JokeAdapter
import com.example.jokeapplication.data.model.JokeEntity
import com.example.jokeapplication.database.JokeDatabase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class JokeFragment : Fragment() {

    lateinit var rootView: View
    lateinit var recyclerView: RecyclerView
    lateinit var mLayoutmanager: LinearLayoutManager
    lateinit var jokeAdapter: JokeAdapter
    lateinit var jokeList: ArrayList<String>
    val viewModel: JokeSearchViewModel by viewModels()
    lateinit var database:JokeDatabase
    val listSize = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(R.layout.fragment_joke, container, false)
        bindViews()

        if(context!=null){
           database = JokeDatabase.getDatabase(requireContext())
        }

        jokeList = ArrayList()
//        set joke adapter
        jokeAdapter = JokeAdapter(jokeList)

//        set recycler view
        mLayoutmanager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = mLayoutmanager
        recyclerView.adapter = jokeAdapter

        return rootView
    }

    private fun bindViews() {
        recyclerView = rootView.findViewById(R.id.recyclerView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getJokesFromDB()

        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                while (true) {
                    viewModel.jokeData()
                    delay(60000)
                }
            }
        }

        lifecycle.coroutineScope.launch {
            viewModel.jokeData.collect {
                it.data?.let {
                    if (jokeList.size >= listSize) {
                        database.jokeEntityDao().deleteJoke()
                    }
                    database.jokeEntityDao().insertJoke(JokeEntity(0,it.joke?:""))
                }

            }
        }
    }

    fun getJokesFromDB(){
        database.jokeEntityDao().getJokes().observe(viewLifecycleOwner, Observer {
            jokeList.clear()
            it.forEach {
                jokeList.add(it.joke?:"")
            }
            jokeAdapter.notifyDataSetChanged()
        })
    }

}
