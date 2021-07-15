package com.jduong.jdsocial.ui.main.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jduong.jdsocial.R
import com.jduong.jdsocial.databinding.UserAlbumViewBinding

class ProfileFragView : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return UserAlbumViewBinding.inflate(inflater,container,false).root
    }


}