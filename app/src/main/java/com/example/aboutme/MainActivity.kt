package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //lateinit var editText: EditText
    //lateinit var nickNameTextView: TextView
    //lateinit var doneButton: Button

    private lateinit var binding: ActivityMainBinding
    private val myName = MyName("abdellatif yabahddou")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

//        doneButton=findViewById(R.id.done_button)
//        doneButton.setOnClickListener {
//            addNickName(it)
//        }
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
//        editText = findViewById(R.id.nickName_edit)
//        nickNameTextView = findViewById(R.id.nickName_text)
        binding.apply {
            //binding.nickNameText.text = binding.nickNameEdit.text
            myName?.nickName = nickNameEdit.text.toString()
            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()
            binding.nickNameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nickNameText.visibility = View.VISIBLE
        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}