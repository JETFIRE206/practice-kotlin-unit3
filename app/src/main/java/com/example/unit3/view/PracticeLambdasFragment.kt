package com.example.unit3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.unit3.R
import com.example.unit3.databinding.FragmentPracticeLambdasBinding

class PracticeLambdasFragment : Fragment(R.layout.fragment_practice_lambdas) {

    // https://developer.android.com/topic/libraries/view-binding#fragments
    private var _binding: FragmentPracticeLambdasBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.fragment_practice_lambdas, container, false)
        _binding = FragmentPracticeLambdasBinding.inflate(inflater, container, false)

        val number: Int = 5
        //val triple: (Int) -> Int = { a: Int -> a * 3}
        val triple: (Int) -> Int = { it * 3 }
        appendText("Triple $number = ${triple(number)}")

        // Lambda Functions
        // https://play.kotlinlang.org/byExample/04_functional/02_Lambdas
        // All examples create a function object that performs upper-casing.
        // So it's a function from String to String

        // A lambda in all its glory, with explicit types everywhere. The lambda is the part in
        // curly braces, which is assigned to a variable of type (String) -> String (a function type).
        val upperCase1: (String) -> String = { str: String -> str.uppercase() }
        appendText("UpperCase1: ${upperCase1("hello")}")

        // Type inference inside lambda: the type of the lambda parameter is inferred from the type
        // of the variable it's assigned to.
        val upperCase2: (String) -> String = { str -> str.uppercase() }
        appendText("UpperCase2: ${upperCase2("hello")}")

        // Type inference outside lambda: the type of the variable is inferred from the type of the
        // lambda parameter and return value.
        val upperCase3 = { str: String -> str.uppercase() }
        appendText("UpperCase3: ${upperCase3("hello")}")

        // You cannot do both together, the compiler has no chance to infer the type that way.
        //val uppercase4 = { str -> str.uppercase() }

        // For lambdas with a single parameter, you don't have to explicitly name it. Instead, you
        // can use the implicit it variable. This is especially useful when the type of it can be
        // inferred (which is often the case).
        val upperCase5: (String) -> String = { it.uppercase() }
        appendText("UpperCase5: ${upperCase5("hello")}")

        // If your lambda consists of a single function call, you may use function pointers (::).
        val upperCase6: (String) -> String = String::uppercase
        appendText("UpperCase6: ${upperCase6("hello")}")

        return binding.root
    }

    private fun appendText(text: String) {
        binding.outputLambda.append(("\n${text}"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}