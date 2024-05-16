package com.example.lenslore

import java.sql.Timestamp

data class Report(
    var reportId : Int,
    var accountId : Int,
    var postId : Int,
    var reportDesciprion : String,
    var reportPhoto : Int,
    var reportTimestamp: String
){
    constructor(accountId: Int, postId: Int, reportDesciprion: String, reportPhoto: Int, reportTimestamp: String) : this (-1, accountId, postId, reportDesciprion, reportPhoto, reportTimestamp)
}
