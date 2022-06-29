package com.example.finalproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.example.finalproject.databinding.FragmentDescriptionBinding
import android.view.ViewGroup
import android.widget.Toast
import com.example.finalproject.R
import com.example.finalproject.provider.ProviderProfile

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DescriptionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DescriptionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!
    var position: Int = 0
    private val descriptionFragment = ListProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        if(arguments != null){
            position = arguments?.getInt("position", 0)!!
        }else{
            Toast.makeText(context, "Posición no encontrada", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animal = ProviderProfile.listProfile[position]
        binding.ivPhoto.bringToFront()
        binding.tvName.bringToFront()
        binding.tvName.text = animal.name
        binding.tvRaceValue.text = animal.race
        binding.ivPhoto.setImageResource(R.drawable.dog)
        binding.tvBodyDescription.text = animal.description
        binding.ivPhoto.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("position", position)
            descriptionFragment.arguments = bundle
            val fragmentManager =  parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fragment_container, descriptionFragment, null)
            fragmentTransaction.commit()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DescriptionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DescriptionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}