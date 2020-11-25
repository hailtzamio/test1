package com.example.test1

import java.io.Serializable

data class Student(

    val name: String?,
    override var type: Int,
    override var imageUrl: String?

) : ViewItem, Serializable {

    private val nameValue: String?
        get() {
            return "$name $imageUrl"
        }

    override var nameByLanguage: String? = nameValue

}