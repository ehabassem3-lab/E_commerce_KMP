package com.example.e_commerce_kmp.features.commerce.ui.tabs.account

import com.example.e_commerce_kmp.features.auth.ui.utilies.Resources
import com.example.e_commerce_kmp.features.network.response.auth.UserDataResponse

data class AccountStates (
    val LogOutState : Resources<Unit>? = null ,
    val AccountDataStates : Resources<UserDataResponse>? = null ,
    val UpdateUserDateApi : Resources<Unit>? = null ,
    val UpdateUserPassWorApi : Resources<Unit>? = null ,
    var currentPassWord : String?= null ,
    var passWord : String?= null ,
    var rePassWord : String?= null ,
    var name : String? = null ,
    var email : String? = null ,
    var phone : String? = null ,
)
sealed class AccountEvents {
    object  onLogOutClick : AccountEvents()
    object getUserData : AccountEvents()
    data class OnNameChanged(val name : String )  : AccountEvents()
    data class OnEmailChanged(val email : String )  : AccountEvents()
    data class OnPhoneChanged(val phone : String )  : AccountEvents()

    data class OnCurrentPassWordChange(val currentPassWord: String) : AccountEvents()
    data class OnPassWordChange(val passWord: String) : AccountEvents()
    data class OnRePassWordChange(val rePassWord: String) : AccountEvents()
    object updateUserPassWord : AccountEvents()

    object updateUserDate : AccountEvents()

}
