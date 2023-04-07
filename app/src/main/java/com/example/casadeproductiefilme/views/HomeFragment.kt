package com.example.casadeproductiefilme.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.casadeproductiefilme.R
import com.example.casadeproductiefilme.adapter.FilterAdapter
import com.example.casadeproductiefilme.adapter.MovieAdapter
import com.example.casadeproductiefilme.databinding.FragmentHomeBinding
import com.example.casadeproductiefilme.presenters.movie.MovieInterface
import com.example.casadeproductiefilme.presenters.movie.MoviePresenter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : Fragment(), MovieInterface.View {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieAdapter: MovieAdapter

    //    @Inject
//    lateinit var movieViewModel: MovieViewModel
    @Inject
    lateinit var presenter: MoviePresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter.mainView = this
        presenter.inflateMovies()
//        initRecyclerView(view)
        return view
    }

    override fun initRecyclerViewFilters() {
        val recyclerViewFilter = binding.root.findViewById<RecyclerView>(R.id.recycler_view_filter)
        val filterList = listOf("artistic", "serial")
        recyclerViewFilter.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewFilter.adapter = FilterAdapter(filterList)
    }


    override fun initRecyclerViewMovies() {

        val recyclerViewMovie = binding.root.findViewById<RecyclerView>(R.id.recycler_view_movie)
        val dataList = presenter.getMovies()
        recyclerViewMovie?.layoutManager = LinearLayoutManager(context)
        movieAdapter = MovieAdapter(dataList, binding.root.context) // it = List<MovieEntity>
        recyclerViewMovie?.adapter = movieAdapter

    }
}

