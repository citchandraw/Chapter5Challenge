package id.cit.suitgame

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class LandingPageLoginFragment : Fragment() {

    lateinit var etName : EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_landing_page_login, container, false)

        etName = view.findViewById(R.id.et_name)

        etName.addTextChangedListener {
            // step 6 kirim data dari fragment ke activity, kirim datanya dengan panggil method
            listener?.afterUserInputName(it.toString())
        }


        // Inflate the layout for this fragment
        return view
    }

    // step 2 kirim data dari fragment ke activity, bikin variable interface fragment
    var listener: UserNameInputListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // step 5 kirim data dari fragment ke activity, init variable listener
        if (context is UserNameInputListener) {
            listener = context
        }
    }

    // step 1 kirim data dari fragment ke activity, bikin interface di fragment
    interface UserNameInputListener {
        fun afterUserInputName(input: String)
    }

}