package com.demo.kalagota
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.codersarts.kalagota.R
import com.codersarts.kalagota.databinding.ActivityMainBinding
import com.demo.kalagota.utils.MainActivityPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Initialize the ViewPager and TabLayout
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        // Create and set up the adapter for the ViewPager
        val adapter = MainActivityPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter

        // Connect the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager)

        // Set tab names
        tabLayout.getTabAt(0)?.text = "Posts"
        tabLayout.getTabAt(1)?.text = "Favorites"
    }
}
