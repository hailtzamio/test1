package com.example.test1

interface ViewItem {
    companion object {
        const val TYPE_CATEGORY = 0
        const val TYPE_PROVIDER = 1
    }

    var type: Int

    var nameByLanguage: String?

    var imageUrl: String?
}