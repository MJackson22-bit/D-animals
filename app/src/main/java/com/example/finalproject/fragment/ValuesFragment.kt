package com.example.finalproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentValuesBinding
import com.example.finalproject.model.ValueFirst
import com.example.finalproject.model.ValueSecond
import com.example.finalproject.provider.ProviderValuesSecond

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ValuesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ValuesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentValuesBinding? = null
    private val binding get() = _binding!!
    private var valuesSecond: ValueSecond? = null
    private var races: List<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentValuesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.npAge.maxValue = 40
        binding.npAge.minValue = 1
        binding.npRaz.minValue = 0
        binding.npRaz.maxValue = 9
        races = resources.getStringArray(R.array.raza).toList()
        binding.npRaz.displayedValues = races.toTypedArray()
    }

    override fun onPause() {
        super.onPause()
        valuesSecond = ValueSecond(binding.npAge.value, races[binding.npRaz.value])
        ProviderValuesSecond.listValuesSecond.clear()
        ProviderValuesSecond.listValuesSecond.add(valuesSecond!!)
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ValuesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ValuesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}