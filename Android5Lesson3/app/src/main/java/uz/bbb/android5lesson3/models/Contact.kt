package uz.bbb.android5lesson3.models

class Contact {
    var id: Int?=null
    var name: String?=null
    var number: String?=null


    constructor(name: String?, number: String?) {
        this.name = name
        this.number = number
    }
}