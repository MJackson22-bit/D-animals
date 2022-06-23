package com.example.finalproject.view

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import com.example.finalproject.R
import com.example.finalproject.adapter.ViewPagerAdapter
import com.example.finalproject.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    private var fake = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = pagerAdapter
        binding.indicator.setViewPager(binding.viewPager)
        binding.btnNext.setOnClickListener {
            fake = if (fake) {
                binding.viewPager.apply {
                    beginFakeDrag()
                    fakeDragBy(-10f)
                    endFakeDrag()
                }
                binding.btnNext.text = "Atrás"
                false
            } else {
                binding.viewPager.apply {
                    beginFakeDrag()
                    fakeDragBy(10f)
                    endFakeDrag()
                }
                binding.btnNext.text = "Siguiente"
                true
            }
        }
        binding.btnCancel.setOnClickListener {
            finish()
        }
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            @RequiresApi(Build.VERSION_CODES.Q)
            @SuppressLint("ResourceAsColor", "ResourceType")
            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    binding.btnNext.text = "Siguiente"
                    fake = true
                } else if (position == 1) {
                    binding.btnNext.text = "Atrás"
                    fake = false
                }
            }
        })
    }

}