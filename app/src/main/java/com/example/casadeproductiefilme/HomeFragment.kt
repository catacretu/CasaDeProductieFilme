package com.example.casadeproductiefilme

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.casadeproductiefilme.adapter.MovieAdapter
import com.example.casadeproductiefilme.databinding.FragmentHomeBinding
import com.example.casadeproductiefilme.presenters.MovieInterface
import com.example.casadeproductiefilme.presenters.MoviePresenter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : Fragment(), MovieInterface.View {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

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
        return view
    }


    override fun initRecyclerView() {

        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recycler_view)
        val dataList = presenter.getMovies()
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        val movieAdapter = MovieAdapter(dataList, binding.root.context) // it = List<MovieEntity>
        Log.d("HERE", "Here")
        recyclerView?.adapter = movieAdapter

    }
}