import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.lab2.R
class FirstFragment : Fragment(R.layout.fragment_first) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sendData: Button = view.findViewById(R.id.send_data)
        sendData.setOnClickListener { openSecondFragment() }
    }
    private fun openSecondFragment() {
        /**
         * Используем FragmentResultAPI для возврата результата
         */
        requireActivity().supportFragmentManager.setFragmentResult(REQUEST_FRAGMENT, bundleOf(EXTRA_TEXT to "Hello from FirstFragment"))
    }
    companion object {
        const val REQUEST_FRAGMENT = "request"
        const val EXTRA_TEXT = "text"
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }
}
