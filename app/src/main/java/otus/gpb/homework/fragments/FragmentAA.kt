package otus.gpb.homework.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback

private const val ARG_PARAM_COLOR = ""

class FragmentAA : Fragment(R.layout.fragment_a_a) {
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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        count = savedInstanceState?.getInt("count") ?: 1
        arguments?.getInt(ARG_PARAM_COLOR)?.let {
            view.setBackgroundColor(it)
        }
        view.findViewById<Button>(R.id.btn_to_ab).setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(
                    R.id.container_ab,
                    FragmentAB.newInstance(colorForBackground)
                )
                .addToBackStack(null)
                .commit()
        }
    }



    companion object {
        fun newInstance(colorForBackground: Int) =
            FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM_COLOR, colorForBackground)
                }
            }
    }
}