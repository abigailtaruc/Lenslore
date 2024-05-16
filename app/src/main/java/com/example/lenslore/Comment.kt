package com.example.lenslore

data class Comment(
    var commentId : Int,
    var postId : Int,
    var accountId : Int,
    var commentContent : String
){
    constructor(postId: Int, accountId: Int, commentContent: String) : this(-1, postId, accountId, commentContent)
}

