package com.example.kotlindemonew.Activity.Retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class ProductResponse {
    @SerializedName("product_list")
    @Expose
    private var productList: List<ProductList>? = null
    @SerializedName("code")
    @Expose
    private var code: String? = null
    @SerializedName("status")
    @Expose
    private var status: String? = null

    fun getProductList(): List<ProductList>? {
        return productList
    }

    fun setProductList(productList: List<ProductList>) {
        this.productList = productList
    }

    fun getCode(): String? {
        return code
    }

    fun setCode(code: String) {
        this.code = code
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String) {
        this.status = status
    }


//    @SerializedName("Product_List")
//    @Expose
//    private var productList: List<ProductList>? = null
//    @SerializedName("code")
//    @Expose
//    private var code: String? = null
//    @SerializedName("status")
//    @Expose
//    private var status: String? = null
//    @SerializedName("message")
//    @Expose
//    private var message: String? = null
//
//    fun getProductList(): List<ProductList>? {
//        return productList
//    }
//
//    fun setProductList(productList: List<ProductList>) {
//        this.productList = productList
//    }
//
//    fun getCode(): String? {
//        return code
//    }
//
//    fun setCode(code: String) {
//        this.code = code
//    }
//
//    fun getStatus(): String? {
//        return status
//    }
//
//    fun setStatus(status: String) {
//        this.status = status
//    }
//
//    fun getMessage(): String? {
//        return message
//    }
//
//    fun setMessage(message: String) {
//        this.message = message
//    }

}