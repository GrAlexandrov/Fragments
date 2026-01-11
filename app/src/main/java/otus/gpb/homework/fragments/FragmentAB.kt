package otus.gpb.homework.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.OnBackPressedCallback

private const val ARG_PARAM_COLOR = ""
private const val ARG_PARAM2 = "param2"

class FragmentAB : Fragment(R.layout.fragment_a_b) {

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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getInt(ARG_PARAM_COLOR)?.let {
            view.setBackgroundColor(it)
        }
    }



    companion object {
        fun newInstance(colorForBackground: Int) =
            FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM_COLOR, colorForBackground)
                }
            }
    }
}