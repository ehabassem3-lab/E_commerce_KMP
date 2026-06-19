package com.example.e_commerce_kmp.features.auth.ui.utilies

fun securePassWord(word : String , isEmail : Boolean = false) : String {
    val hiddenEmail = StringBuilder()
    if (isEmail) {
        for (i in 0 until word.length) {
            if (word[i] == '@') {
                hiddenEmail.append("@gmail.com ")
                return hiddenEmail.toString()
            } else {
                hiddenEmail.append("*")
            }

        }

        return hiddenEmail.toString()
    }
    else{
        for (i in 0 until word.length) {
            hiddenEmail.append("*")
        }
    }

    return hiddenEmail.toString()


}