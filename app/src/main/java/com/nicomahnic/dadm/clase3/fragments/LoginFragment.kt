package com.nicomahnic.dadm.clase3.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.nicomahnic.dadm.clase3.entities.User
import com.nicomahnic.dadm.clase3.R
import com.nicomahnic.dadm.clase3.activities.SecondActivity


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(R.layout.fragment_login) {

    lateinit var btnEnter : Button
    lateinit var edtUser : EditText
    lateinit var edtPasswd : EditText
    var btnUser : Boolean = false
    var btnPasswd : Boolean = false

    lateinit var v : View

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        v = view
        btnEnter = v.findViewById(R.id.btnEnter)
        edtUser = v.findViewById(R.id.edtUser)
        edtPasswd = v.findViewById(R.id.edtPasswd)

        edtUser.apply { addTextChangedListener(userWatcher) }

        edtPasswd.apply { addTextChangedListener(passwdWatcher) }

        btnEnter.isEnabled = false
    }

    private val userWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            println("afterTextChanged -> $s")

            btnUser = !s.toString().isNullOrEmpty()
            btnEnter.isEnabled = btnUser && btnPasswd

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private val passwdWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            println("afterTextChanged -> $s")

            btnPasswd = !s.toString().isNullOrEmpty()
            btnEnter.isEnabled = btnUser && btnPasswd

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    override fun onStart() {
        super.onStart()

        val userList: MutableList<User> = ArrayList<User>()
        userList.add(User("Mash", "1234"))
        userList.add(User("Juanma", "1234"))
        userList.add(User("Juani", "1234"))
        userList.add(User("Eric", "1234"))
        userList.add(User("Tiago", "1234"))


        btnEnter.setOnClickListener {
            val validUser = userList.find{it.name == edtUser.text.toString()}

            validateUser(validUser)?.let{
                val sendIntent = Intent(context, SecondActivity::class.java)
                sendIntent.putExtra(Intent.EXTRA_TEXT, validUser!!.name)
                startActivity(sendIntent)
            }
        }
    }

    private fun validateUser(validUser: User?) : Boolean? {
        validUser?.let{ user ->
            if(user.passwd == edtPasswd.text.toString()) user.checked = true
            if(user.checked) {
                return true
            }else{
                Snackbar.make(v, "Password no valida", Snackbar.LENGTH_SHORT).show()
            }
        } ?: run {
            Snackbar.make(v, "Usuario no registrado", Snackbar.LENGTH_SHORT).show()
        }
        return null
    }
}