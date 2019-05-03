package com.example.kotlindemonew.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kotlindemonew.Activity.Adapter.RecyclerviewAdapter
import com.example.kotlindemonew.Activity.Retrofit.*
import com.example.kotlindemonew.R
import retrofit2.Call
import retrofit2.Callback

class HomeActivity:AppCompatActivity() {
    @BindView(R.id.recyclerview_list)lateinit var recyclerView: RecyclerView

   // var myItem: List<ProductList> = ArrayList()
    private var myItem: List<ProductList>? = ArrayList()
   /// val users = mutableListOf<MyItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        ButterKnife.bind(this)
        loaddata()
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = RecyclerviewAdapter(myItem, this)



    }

    fun loaddata(){

        //var users: MutableList<MyItem> = mutableListOf( MyItem("Tom", 32), User("John", 64) )
//        myItem.add(MyItem("1","PiZZa","text","http://api.learn2crack.com/android/images/donut.png"))
//        myItem.add(MyItem("2","Pasta","text","http://api.learn2crack.com/android/images/donut.png"))
//        myItem.add(MyItem("3","Megi","text","http://api.learn2crack.com/android/images/donut.png"))
//        myItem.add(MyItem("4","PiZZa","text","http://api.learn2crack.com/android/images/donut.png"))
//        //myItem.add(MyItem("5","PiZZa","text","https://www.tasteofhome.com/recipes/chicken-pizza/"))
       // myItem.add(MyItem("6","PiZZa","text","https://www.pexels.com/photo/vegetables-italian-pizza-restaurant-2232/"))



            val apiInterface = APIClient.getClient().create(APIInterface::class.java)
            // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val req = apiInterface.list()
            req.enqueue(object : Callback<ProductResponse> {
                override fun onResponse(call: Call<ProductResponse>, response: retrofit2.Response<ProductResponse>) {
                    ///    progressDialog.dismiss();
                    // myProgressDialog.dismiss()
                    if (response.body().getCode().equals("1")) {
//                        val intent = Intent(this@HomeActivity,HomeActivity::class.java)
//                        startActivity(intent)
                       // Toast.makeText(this@HomeActivity, "Login Sucessfully", Toast.LENGTH_LONG).show()
//                    Toast.makeText(this@MainActivity, " Loan Photo Upload  Successfully", Toast.LENGTH_SHORT)
//                        .show()
//                    val i = Intent(this@MainActivity, HomeActivity::class.java)
//                    startActivity(i)
                        myItem=response.body().getProductList();
                        recyclerView.adapter = RecyclerviewAdapter(myItem, this@HomeActivity)
                    }
                    if (response.body().getCode().equals("2")) {
                        Toast.makeText(this@HomeActivity, "Please fill all valid details", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                    t.printStackTrace()
                    //myProgressDialog.dismiss()
                    Toast.makeText(this@HomeActivity, "Server Down or Network problem", Toast.LENGTH_SHORT).show()

                }
            })



    }




}