package com.jduong.jdsocial.ui.main.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jduong.jdsocial.R
import com.jduong.jdsocial.data.repository.JsonViewModel
import com.jduong.jdsocial.data.repository.UserSelectionRepository
import com.jduong.jdsocial.data.room.JDdatabase
import com.jduong.jdsocial.databinding.PostAdapterBinding
import com.jduong.jdsocial.ui.main.adapter.CommentsAdapter
import com.jduong.jdsocial.ui.main.adapter.PostAdapter
import com.jduong.jdsocial.ui.main.viewmodel.*


class PostFragView : Fragment() {

    private lateinit var postListViewModel : PostListViewModel
    private lateinit var commentsListViewModel : CommentsListViewModel
    private  val jsonViewModel : JsonViewModel = JsonViewModel()
    private val postAdapter = PostAdapter()
    private val commentAdapter = CommentsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return PostAdapterBinding.inflate(inflater, container, false).root
    }


    override fun onPause() {
        super.onPause()

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = PostAdapterBinding.bind(view)
        val postDao = JDdatabase.getDatabase(requireContext()).postDao()
        val postList = jsonViewModel.getTitles()

        val postEntry : PostEntryViewModel by viewModels {
            PostViewModelFactory(postDao)

        }

        for (posts in postList){
         val postid = posts.postID
         val userPost = posts.userPost
         val userid = posts.userID

         postEntry.addData(postid,userPost,userid){

         }

        }


        postListViewModel.postList.observe(viewLifecycleOwner){
        posts->postAdapter.submitList(posts)


        }

        val selectionView : SelectionFragViewModel by viewModels {
            SelectionViewModelFactory(UserSelectionRepository.getInstance(requireContext()))
        }

        selectionView.checkPostSelection().observe(viewLifecycleOwner){ selection->

        }
        selectionView.savePostSelection(true)



    }


}