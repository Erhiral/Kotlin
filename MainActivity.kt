package com.example.kotlindemonew.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kotlindemonew.Activity.Retrofit.APIClient
import com.example.kotlindemonew.Activity.Retrofit.APIInterface
import com.example.kotlindemonew.Activity.Retrofit.LoginResponse
import com.example.kotlindemonew.R
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
   // var  etUsername=null;
    @BindView(R.id.username) lateinit var username: TextInputEditText
    @BindView(R.id.password) lateinit var password: TextInputEditText
    @BindView(R.id.btn_submit) lateinit var btn_submit: Button
    @BindView(R.id.singup) lateinit var singup: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this);

        btn_submit.setOnClickListener {
            val user_name = username.text;
            val password1 = password.text;
            if(username?.text.isNullOrEmpty()){
                username?.error ="Please Enter Your Name."
            } else if(password?.text.isNullOrEmpty()){
                password?.error = "Please Enter Your Password."
            }else {
                //login()
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(this@MainActivity, "Login Sucessfully" + user_name, Toast.LENGTH_LONG).show()
            }
            // your code to validate the user_name and password combination
            // and verify the same
            }

        singup.setOnClickListener(){
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        val apiInterface = APIClient.getClient().create(APIInterface::class.java)
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val req = apiInterface.login("KT987","0987")
        req.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: retrofit2.Response<LoginResponse>) {
                ///    progressDialog.dismiss();
               // myProgressDialog.dismiss()
                if (response.body().getCode().equals("1")) {
                    val intent = Intent(this@MainActivity,HomeActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this@MainActivity, "Login Sucessfully", Toast.LENGTH_LONG).show()
//                    Toast.makeText(this@MainActivity, " Loan Photo Upload  Successfully", Toast.LENGTH_SHORT)
//                        .show()
//                    val i = Intent(this@MainActivity, HomeActivity::class.java)
//                    startActivity(i)
                }
                if (response.body().getCode().equals("2")) {
                    Toast.makeText(this@MainActivity, "Please fill all valid details", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                t.printStackTrace()
                //myProgressDialog.dismiss()
                Toast.makeText(this@MainActivity, "Server Down or Network problem", Toast.LENGTH_SHORT).show()
                Log.d("mytag", "Filemanger Fail")
            }
        })


    }


}
