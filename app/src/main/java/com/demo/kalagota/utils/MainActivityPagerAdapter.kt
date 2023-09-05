package com.demo.kalagota.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.demo.kalagota.Feature.favorite.FavoritesFragment
import com.demo.kalagota.Feature.posts.ui.PostListFragment

class MainActivityPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 2 // Number of tabs (Posts and Favorites)
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PostListFragment() // Your PostListFragment
            1 -> FavoritesFragment() // Your FavoritesFragment
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
