package com.example.lenslore

data class Like(
    var likeId : Int,
    var postId : Int,
    var accountID : Int
){
    constructor(postId: Int, accountID: Int) : this(-1, postId, accountID)
}
