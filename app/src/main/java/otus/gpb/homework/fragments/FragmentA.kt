package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
private const val ARG_PARAM_COLOR = ""
private const val ARG_PARAM2_COUNT = 1

class FragmentA : Fragment( R.layout.fragment_a) {
    private var count = 1
    private var colorForBackground= ColorGenerator.generateColor()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    requireActivity().onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this, // LifecycleOwner
            callback
        )
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_to_aa).setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(
                    R.id.container_aa,
                    FragmentAA.newInstance(colorForBackground)
                )
                .addToBackStack(null)
                .commit()
        }


    }


}