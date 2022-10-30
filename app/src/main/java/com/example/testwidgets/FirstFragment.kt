package com.example.testwidgets

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testwidgets.databinding.AlertDialogCustomTitleBinding
import com.example.testwidgets.databinding.FragmentFirstBinding
import com.example.testwidgets.dialogs.displayAlert

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var _customDialog: AlertDialogCustomTitleBinding? = null
    private var _viewGroup: ViewGroup? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewGroup = container
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        _customDialog = AlertDialogCustomTitleBinding.inflate(inflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener{
            displayAlert(
                title = R.string.title,
                message = R.string.message,
                positiveButton = R.string.next,
                positiveDialogInterface = { _, _ ->
                    Log.i("tag", "clicked")
                },
                cancelTitle = android.R.string.cancel,
                binding = _customDialog!!,
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}