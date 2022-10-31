package com.example.unit3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.unit3.R
import com.example.unit3.databinding.FragmentPracticeHighOrderFuncBinding

class PracticeHighOrderFunc : Fragment(R.layout.fragment_practice_high_order_func) {

    private var _binding: FragmentPracticeHighOrderFuncBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentPracticeHighOrderFuncBinding.inflate(inflater, container, false)

        val people = listOf("Fred", "Ann", "Barbara", "Joe")
        appendText("Original List:")
        //people.forEach { appendText(it) }
        appendText(people.toString())

        // Note: To compare two objects for sorting, the convention is to return a value less than 0
        // if the first object is less than the second, 0 if they are equal, and a value greater than
        // 0 if the first object is greater than the second.
        appendText("\nSorted by Length:")
        //people.sortedWith { str1: String, str2: String -> str1.length - str2.length}
        //    .forEach { appendText(it) }
        appendText(people.sortedWith { str1: String, str2: String -> str1.length - str2.length }
            .toString())

        return binding.root
    }

    private fun appendText(text: String) {
        binding.outputLambda.append("\n${text}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}