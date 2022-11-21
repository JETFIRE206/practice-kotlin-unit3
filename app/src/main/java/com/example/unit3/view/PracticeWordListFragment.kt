package com.example.unit3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.unit3.R
import com.example.unit3.databinding.FragmentPracticeWordListBinding

class PracticeWordListFragment : Fragment(R.layout.fragment_practice_word_list) {

    // https://developer.android.com/topic/libraries/view-binding#fragments
    private var _binding: FragmentPracticeWordListBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPracticeWordListBinding.inflate(inflater, container, false)

        val words = listOf(
            "about",
            "acute",
            "awesome",
            "balloon",
            "best",
            "brief",
            "class",
            "coffee",
            "creative"
        )

        // Print words that start with "b"
        val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        appendText("Words starting with 'b':")
        appendText(filteredWords.toString())

        // Print shuffled words that start with "b"
        val filteredShuffledWords = words.filter { it.startsWith("b", ignoreCase = true) }
            .shuffled()
        appendText("\nShuffled words starting with 'b':")
        appendText(filteredShuffledWords.toString())

        // Print first 2 shuffled words that start with "b"
        val filteredTwoShuffledWords = words.filter { it.startsWith("b", ignoreCase = true) }
            .shuffled()
            .take(2)
        appendText("\nFirst 2 shuffled words starting with 'b':")
        appendText(filteredTwoShuffledWords.toString())

        // Print first 2 shuffled words that start with "b" sorted.
        val filteredTwoShuffledWordsSorted = words.filter { it.startsWith("b", ignoreCase = true) }
            .shuffled()
            .take(2)
            .sorted()
        appendText("\nFirst 2 shuffled words starting with 'b' sorted:")
        appendText(filteredTwoShuffledWordsSorted.toString())

        // Print one random word that starts with "c".
        val startsWithC = words.filter { it.startsWith("c", ignoreCase = true) }
            .shuffled()
            .take(1)
        appendText("\nRandom word starting with 'c':")
        appendText(startsWithC.toString())

        return binding.root
    }

    private fun appendText(text: String) {
        binding.outputWordList.append("\n${text}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}