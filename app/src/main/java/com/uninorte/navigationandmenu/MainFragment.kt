package com.uninorte.navigationandmenu

import android.os.Bundle
import android.system.Os.accept
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button).setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToSecondFragment().setElParametro(22)
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.buttonAlert).setOnClickListener{
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setNeutralButton(R.string.cancel) { dialog, which ->
                    Log.d("NavigationAndMenuDebug","Diálogo cancelar")
                }
                .setNegativeButton(resources.getString(R.string.decline)) { dialog, which ->
                    Log.d("NavigationAndMenuDebug","Diálogo declinar")
                }
                .setPositiveButton(R.string.accept) { dialog, which ->
                    Log.d("NavigationAndMenuDebug","Diálogo aceptar")
                }
                .show()
        }

        view.findViewById<Button>(R.id.buttonDialogoLista).setOnClickListener{
            val items = arrayOf("Item 1", "Item 2", "Item 3")

            MaterialAlertDialogBuilder(requireContext())
                .setTitle(resources.getString(R.string.dialog_title))
                .setItems(items) { dialog, which ->
                    Log.d("NavigationAndMenuDebug","Diálogo lista opción "+which)
                }
                .show()
        }

    }



}