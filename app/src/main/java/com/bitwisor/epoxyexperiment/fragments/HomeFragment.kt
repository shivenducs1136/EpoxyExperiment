package com.bitwisor.epoxyexperiment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitwisor.epoxyexperiment.DataClass.Article
import com.bitwisor.epoxyexperiment.DataClass.MyDataClass
import com.bitwisor.epoxyexperiment.ViewModel.HomeFragmentViewModel
import com.bitwisor.epoxyexperiment.adapter.HomeFragmentEpoxyController
import com.bitwisor.epoxyexperiment.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel:HomeFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val epoxyrecyclerView = binding.epoxyrecyclerview

        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        viewModel.getNews()

        epoxyrecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val data = ArrayList<MyDataClass>()

        data.add(MyDataClass("Shivendu Mishra"))
        data.add(MyDataClass("Yashasvi Baliyan"))
        data.add(MyDataClass("Utkarsh Arora"))
        data.add(MyDataClass("Sanidhya Sharma"))
        data.add(MyDataClass("Ayush Kumar"))
        data.add(MyDataClass("Arpit Shukla"))
        data.add(MyDataClass("Yashasvi Singh"))
        data.add(MyDataClass("Kshitij Pal"))
        data.add(MyDataClass("Saransh Mittal"))
        data.add(MyDataClass("Sneha Jaiswal"))
        data.add(MyDataClass("Shruti Jain"))

        val epoxyController = HomeFragmentEpoxyController(requireContext())
        epoxyrecyclerView.setController(epoxyController)
//        epoxyrecyclerView.addItemDecoration(DividerItemDecoration(requireActivity(),RecyclerView.VERTICAL))
        epoxyrecyclerView.adapter = epoxyController.adapter
        viewModel.myresponse.observe(viewLifecycleOwner,{
            epoxyController.mList = it.articles as ArrayList<Article>
        })

    }
}