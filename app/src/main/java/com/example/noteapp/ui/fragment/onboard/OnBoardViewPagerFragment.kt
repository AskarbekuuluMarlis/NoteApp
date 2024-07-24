package com.example.noteapp.ui.fragment.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardViewPagerBinding

class OnBoardViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardViewPagerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0 -> {
                tvOn.text = "Очень удобный функционал"
                lottie.setAnimation(R.raw.lottie1)
            }
            1 -> {
                tvOn.text = "Быстрый, качественный продукт"
                lottie.setAnimation(R.raw.lottie2)
                point1.setImageResource(R.drawable.gray_point)
                point2.setImageResource(R.drawable.orange_point)
            }
            2 -> {
                tvOn.text = "Куча функций и интересных фишек"
                lottie.setAnimation(R.raw.lottie3)
                point1.setImageResource(R.drawable.gray_point)
                point2.setImageResource(R.drawable.gray_point)
                point3.setImageResource(R.drawable.orange_point)
            }
        }
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}