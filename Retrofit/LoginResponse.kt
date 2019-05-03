package com.example.kotlindemonew.Activity.Retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class LoginResponse {

    @SerializedName("code")
    @Expose
    private var code: String? = null
    @SerializedName("status")
    @Expose
    private var status: String? = null
    @SerializedName("message")
    @Expose
    private var message: String? = null
    @SerializedName("l_id")
    @Expose
    private var lId: String? = null
    @SerializedName("adminCode")
    @Expose
    private var adminCode: String? = null
    @SerializedName("adminPassword")
    @Expose
    private var adminPassword: String? = null
    @SerializedName("updated_time")
    @Expose
    private var updatedTime: String? = null


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

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String) {
        this.message = message
    }

    fun getLId(): String? {
        return lId
    }

    fun setLId(lId: String) {
        this.lId = lId
    }

    fun getAdminCode(): String? {
        return adminCode
    }

    fun setAdminCode(adminCode: String) {
        this.adminCode = adminCode
    }

    fun getAdminPassword(): String? {
        return adminPassword
    }

    fun setAdminPassword(adminPassword: String) {
        this.adminPassword = adminPassword
    }

    fun getUpdatedTime(): String? {
        return updatedTime
    }

    fun setUpdatedTime(updatedTime: String) {
        this.updatedTime = updatedTime
    }
}