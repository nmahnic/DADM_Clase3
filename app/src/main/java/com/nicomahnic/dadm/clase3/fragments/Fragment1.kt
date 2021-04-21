package com.nicomahnic.dadm.clase3.fragments

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


/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {

    lateinit var btnEnter : Button
    lateinit var edtUser : EditText
    lateinit var edtPasswd : EditText
    var btnUser : Boolean = false
    var btnPasswd : Boolean = false

    lateinit var v : View

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_1, container, false)

        btnEnter = v.findViewById(R.id.btnEnter)
        edtUser = v.findViewById(R.id.edtUser)
        edtPasswd = v.findViewById(R.id.edtPasswd)

        edtUser.apply {
            addTextChangedListener(userWatcher)
        }

        edtPasswd.apply {
            addTextChangedListener(passwdWatcher)
        }

        btnEnter.isEnabled = false


        return v
    }

    private val userWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            println("afterTextChanged -> $s")

            btnUser = !s.toString().isNullOrEmpty()
            btnEnter.isEnabled = btnUser && btnPasswd

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //Do nothing
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //Do nothing
        }
    }

    private val passwdWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            println("afterTextChanged -> $s")

            btnPasswd = !s.toString().isNullOrEmpty()
            btnEnter.isEnabled = btnUser && btnPasswd

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //Do nothing
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //Do nothing
        }
    }

    override fun onStart() {
        super.onStart()

        var userList: MutableList<User> = ArrayList<User>()
        userList.add(User("Mash", "1234"))
        userList.add(User("Juanma", "1234"))
        userList.add(User("Juani", "1234"))
        userList.add(User("Eric", "1234"))
        userList.add(User("Tiago", "1234"))


        btnEnter.setOnClickListener {
            val validUser = userList.find{it.name == edtUser.text.toString()}

            validateUser(validUser)?.let{
                val action = Fragment1Directions.actionFragment1ToSecondActivity()
//                val action = Fragment1Directions.actionFragment1ToSecondActivity(validUser!!.name)
                v.findNavController().navigate(action)
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