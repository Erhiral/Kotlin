package com.example.kotlindemonew.Activity.Adapter

import android.content.Context
import android.content.Intent
import android.support.annotation.Nullable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kotlindemonew.Activity.MyItem
import com.example.kotlindemonew.Activity.QRCodeActivity
import com.example.kotlindemonew.Activity.Retrofit.ProductList
import com.example.kotlindemonew.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerviewAdapter (var items : List<ProductList>?, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       /// TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var  item = items?.get(position)
        holder?.title?.text = item?.getName()
        holder?.description?.text=item?.getPrice()
      //  holder.profile_image
        Log.d("myytag","imagedescription"+item?.getImg())
        holder.profile_image.setOnClickListener {
            val intent= Intent(context, QRCodeActivity::class.java)
            context.startActivity(intent)
        }

        Picasso.with(context)
            .load(item?.getImg())
            .placeholder(R.drawable.ic_launcher_background) //optional
                                   //optional
            .into(holder!!.profile_image);


    }
    override fun getItemCount(): Int {
        return items!!.size
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    //@Nullable
    @BindView(R.id.title)
    lateinit var title: TextView
    //@Nullable
    @BindView(R.id.description)
    lateinit var description: TextView
    //@Nullable
    @BindView(R.id.profile_image)
    lateinit var profile_image: CircleImageView
    // Holds the TextView that will add each animal to
    init {
        ButterKnife.bind(this, view)
    }
    //val tvAnimalType = view.tv_animal_type
}
