package com.example.lenslore

import java.sql.Timestamp

data class Post(
    var postId : Int,
    var accountID : Int,
    var picture : Int,
    var caption : String,
    var postTimestamp: String
){
    constructor(accountID: Int, picture: Int, caption: String, postTimestamp: String) : this (-1, accountID, picture, caption, postTimestamp)
}
