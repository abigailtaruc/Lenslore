package com.example.lenslore

import java.sql.Timestamp

data class Chat(
    var chatId : Int,
    var accountId1 : Int,
    var accountId2 : Int,
    var chatContent : String,
    var chatTimestamp: String
){
    constructor(accountId1: Int , accountId2: Int, chatContent: String) : this(-1, accountId1, accountId2, chatContent,  "")
}
