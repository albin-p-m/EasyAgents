package com.example.easyagents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        db = FirebaseFirestore.getInstance()
        val tvLogin: TextView = findViewById(R.id.tvLoginRegister)
        val etName: EditText = findViewById(R.id.etNameRegister)
        val etPhone: EditText = findViewById(R.id.etPhoneRegister)
        val etPassword: EditText = findViewById(R.id.etPasswordRegister)
        val etConfirmPassword: EditText = findViewById(R.id.etConfirmPasswordRegister)
        val btnRegister: Button = findViewById(R.id.btnRegisterRegister)
        val rbUserType: RadioGroup = findViewById(R.id.rbUserTypeRegister)
        lateinit var msg: String

        tvLogin.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            onStop()
        }

        btnRegister.setOnClickListener {
            msg = if (etName.text.toString().isEmpty() || etPhone.text.toString()
                    .isEmpty() || etPassword.text.toString()
                    .isEmpty() || etConfirmPassword.text.toString()
                    .isEmpty() || rbUserType.checkedRadioButtonId == -1
            ) {
                "the field is empty"
            }else if (etPassword.text.toString() == etConfirmPassword.text.toString()){
                "the password doesn't match"
            }else{
                "the data will be submitted"
            }
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }
}