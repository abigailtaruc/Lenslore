package com.example.lenslore

data class Account(
                   var accountId: Int,
                   var profilePic: Int,
                   var username : String,
                   var unique_username : String,
                   var password : String,
                   var email : String,
                   var description : String
                   ) {
    constructor(username: String, password: String, email: String) :
            this(
                -1,
                R.drawable.profile_icon,
                username,
                "",
                password,
                email,
                ""
            )
    constructor(accountId: Int, username: String, password: String, email: String) :
            this(
                accountId,
                R.drawable.profile_icon,
                username,
                "",
                password,
                email,
                ""
            )


}

/*
data class Account(
                   var username : String,
                   var password : String,
                   var email : String,
                   var pro
                   ) {
    var accountId: Int = 0
    //need to check
    var unique_username = ""
    var profilePic: Int = R.drawable.profile_icon
    var description = ""
}
 */
