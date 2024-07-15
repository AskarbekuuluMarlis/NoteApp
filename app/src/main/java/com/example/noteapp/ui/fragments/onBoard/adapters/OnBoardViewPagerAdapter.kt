package com.example.noteapp.ui.fragments.onBoard.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.noteapp.ui.fragments.onBoard.OnBoardViewPagerFragment
import com.example.noteapp.ui.fragments.onBoard.OnBoardViewPagerFragment.Companion.ARG_ONBOARD_POSITION

class OnBoardViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardViewPagerFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }
    }
}