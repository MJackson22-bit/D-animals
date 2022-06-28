package com.example.finalproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentGeneralInfoBinding
import com.example.finalproject.databinding.FragmentValuesBinding
import com.example.finalproject.model.ValueFirst
import com.example.finalproject.provider.ProviderValuesFirst

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GeneralInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GeneralInfoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentGeneralInfoBinding? = null
    private val binding get() = _binding!!
    private var valueFirst: ValueFirst? = null

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
        _binding = FragmentGeneralInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        valueFirst = ValueFirst(binding.etName.text.toString(), binding.etDescription.text.toString())
        ProviderValuesFirst.listValuesFirst.clear()
        ProviderValuesFirst.listValuesFirst.add(valueFirst!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
         * @return A new instance of fragment GeneralInfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GeneralInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}