package com.example.testwidgets.dialogs

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.testwidgets.databinding.AlertDialogCustomTitleBinding
import com.example.testwidgets.R

fun Fragment.displayAlert(
    title: Int,
    message: Int,
    positiveButton: Int,
    positiveDialogInterface: DialogInterface.OnClickListener? = null,
    extraTitle: Int? = null,
    extraDialogInterface: DialogInterface.OnClickListener? = null,
    cancelTitle: Int,
    cancelDialogInterface: DialogInterface.OnClickListener? = null,
    binding: AlertDialogCustomTitleBinding,
) {
    val builder = AlertDialog.Builder(requireContext())

    with(builder) {
        val titleView = layoutInflater.inflate(R.layout.alert_dialog_custom_title, null)
        binding.tvTitle.text = getString(title)
        setCustomTitle(titleView)

        setMessage(message)
        setPositiveButton(positiveButton, positiveDialogInterface)
        extraTitle?.let {
            setNeutralButton(it, extraDialogInterface)
        }
        setNegativeButton(cancelTitle, cancelDialogInterface)

        show()
    }
}