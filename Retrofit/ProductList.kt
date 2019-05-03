package com.example.kotlindemonew.Activity.Retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class ProductList {
    @SerializedName("id")
    @Expose
    private var id: String? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("price")
    @Expose
    private var price: String? = null
    @SerializedName("img")
    @Expose
    private var img: String? = null

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getPrice(): String? {
        return price
    }

    fun setPrice(price: String) {
        this.price = price
    }

    fun getImg(): String? {
        return img
    }

    fun setImg(img: String) {
        this.img = img
    }


//    @SerializedName("pro_id")
//    @Expose
//    private var proId: String? = null
//    @SerializedName("pro_name")
//    @Expose
//    private var proName: String? = null
//    @SerializedName("pro_updated_at")
//    @Expose
//    private var proUpdatedAt: String? = null
//
//    fun getProId(): String? {
//        return proId
//    }
//
//    fun setProId(proId: String) {
//        this.proId = proId
//    }
//
//    fun getProName(): String? {
//        return proName
//    }
//
//    fun setProName(proName: String) {
//        this.proName = proName
//    }
//
//    fun getProUpdatedAt(): String? {
//        return proUpdatedAt
//    }
//
//    fun setProUpdatedAt(proUpdatedAt: String) {
//        this.proUpdatedAt = proUpdatedAt
//    }
}