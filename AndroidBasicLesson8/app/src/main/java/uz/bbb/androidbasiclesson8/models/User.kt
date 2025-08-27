package uz.bbb.androidbasiclesson8.models

import java.io.Serializable

class User: Serializable {

    var username:String? = null
    var password:String? = null

    constructor(username: String?, password: String?) {
        this.username = username
        this.password = password
    }
}