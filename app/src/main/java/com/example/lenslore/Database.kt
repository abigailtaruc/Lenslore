package com.example.lenslore

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Toast

val DATABASE_NAME = "LensloreDB"

//Account
val ACCOUNT_TABLE = "Account"
val ACCOUNT_ID = "account_id"
val PROFILE_PIC = "profile_pic"
val USERNAME = "username"
val UNIQUE_USERNAME = "unique_username"
val PASSWORD = "password"
val EMAIL = "email"
val ACCOUNT_DESCRIPTION = "account_description"

//Chat
val CHAT_TABLE = "Chat"
val CHAT_ID = "chat_Id"
val ACCOUNT_ID_1 = "account_id1"
val ACCOUNT_ID_2 = "account_id2"
val CHAT_CONTENT = "chat_content"
val CHAT_TIMESTAMP = "chat_timestamp"

//Comment
val COMMENT_TABLE = "Comment"
val COMMENT_ID = "comment_id"
val COMMENT_CONTENT = "comment_content"

//Like
val LIKE_TABLE = "Like"
val LIKE_ID = "like_id"

//Post
val POST_TABLE = "Post"
val POST_ID = "post_id"
val PICTURE = "picture"
val CAPTION = "caption"
val POST_TIMESTAMP = "post_timestamp"

//Report
val REPORT_ID = "report_id"
val REPORT_DESCRIPTION = "report_description"
val REPORT_PHOTO = "report_photo"
val REPORT_TIMESTAMP = "report_timestamp"
val REPORT_TABLE = "report_table"

//Creating Database
class Database (var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    //Creating Tables
    override fun onCreate(db: SQLiteDatabase?) {
        val createAccountTable = "CREATE TABLE " + ACCOUNT_TABLE + " (" +
            ACCOUNT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PROFILE_PIC + " BLOB, " +
            USERNAME + " VARCHAR(255), " +
            UNIQUE_USERNAME + " VARCHAR(255), " +
            PASSWORD + " VARCHAR(255), " +
            EMAIL + " VARCHAR(255), " +
            ACCOUNT_DESCRIPTION + " VARCHAR(255) )"

        db?.execSQL(createAccountTable)

        val createChatTable = "CREATE TABLE " + CHAT_TABLE + " (" +
                CHAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ACCOUNT_ID_1 + " INTEGER, " +
                ACCOUNT_ID_2 + " INTEGER, " +
                CHAT_CONTENT + " VARCHAR(255), " +
                CHAT_TIMESTAMP + " VARCHAR(255) )"

        db?.execSQL(createChatTable)

        val createCommentTable = "CREATE TABLE " + COMMENT_TABLE + " (" +
                COMMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                POST_ID + " INTEGER, " +
                ACCOUNT_ID + " INTEGER, " +
                COMMENT_CONTENT + " VARCHAR(255) )"

        db?.execSQL(createCommentTable)

        val createLikeTable = "CREATE TABLE " + LIKE_TABLE + " (" +
                LIKE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                POST_ID + " INTEGER, " +
                ACCOUNT_ID + " INTEGER )"

        db?.execSQL(createLikeTable)

        val createPostTable = "CREATE TABLE " + POST_TABLE + " (" +
                POST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ACCOUNT_ID + " INTEGER, " +
                PICTURE + " BLOB, " +
                CAPTION + " VARCHAR(255), " +
                POST_TIMESTAMP + " VARCHAR(255) )"

        db?.execSQL(createPostTable)

        val createReportTable = "CREATE TABLE " + REPORT_TABLE + " (" +
                REPORT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ACCOUNT_ID + " INTEGER, " +
                POST_ID + " INTEGER, " +
                REPORT_DESCRIPTION + " VARCHAR(255), " +
                REPORT_PHOTO + " BLOB, " +
                REPORT_TIMESTAMP + " VARCHAR(255) )"

        db?.execSQL(createReportTable)
    }

    //Setting version of database
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    //Inserting into database
    fun insertData(account: Account){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(PROFILE_PIC, account.profilePic)
        cv.put(USERNAME, account.username)
        cv.put(UNIQUE_USERNAME, account.unique_username)
        cv.put(PASSWORD, account.password)
        cv.put(EMAIL, account.email)
        cv.put(ACCOUNT_DESCRIPTION, account.description)
        val result = db.insert(ACCOUNT_TABLE, null, cv)
        if (result == (-1).toLong()){
            Toast.makeText(context, "Error creating account", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Account created successfully", Toast.LENGTH_SHORT).show()
        }
        db.close()
    }

    fun insertData(chat: Chat){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(ACCOUNT_ID_1, chat.accountId1)
        cv.put(ACCOUNT_ID_2, chat.accountId2)
        cv.put(CHAT_CONTENT, chat.chatContent)
        cv.put(CHAT_TIMESTAMP, chat.chatTimestamp)
        val result = db.insert(CHAT_TABLE, null, cv)
        if (result == (-1).toLong()){
            Toast.makeText(context, "Error sending message", Toast.LENGTH_SHORT).show()
        }

        else {
            Toast.makeText(context, "vhat", Toast.LENGTH_SHORT).show()
        }
        db.close()
    }



    fun insertData(comment: Comment){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(POST_ID, comment.postId)
        cv.put(ACCOUNT_ID, comment.accountId)
        cv.put(COMMENT_CONTENT, comment.commentContent)
        val result = db.insert(COMMENT_TABLE, null, cv)
        if (result == (-1).toLong()){
            Toast.makeText(context, "Error posting comment", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Comment posted successfully", Toast.LENGTH_SHORT).show()
        }
        db.close()
    }

    fun insertData(like: Like){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(POST_ID, like.postId)
        cv.put(ACCOUNT_ID, like.accountID)
        val result = db.insert(LIKE_TABLE, null, cv)
        if (result == (-1).toLong()){
            Toast.makeText(context, "Error liking post", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Liked post", Toast.LENGTH_SHORT).show()
        }
        db.close()
    }

    fun insertData(post: Post){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(ACCOUNT_ID, post.accountID)
        cv.put(PICTURE, post.picture)
        cv.put(CAPTION, post.caption)
        cv.put(POST_TIMESTAMP, post.postTimestamp)
        val result = db.insert(POST_TABLE, null, cv)
        if (result == (-1).toLong()){
            Toast.makeText(context, "Error uploading post", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Post uploaded successfully", Toast.LENGTH_SHORT).show()
        }
        db.close()
    }

    fun insertData(report: Report){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(ACCOUNT_ID, report.accountId)
        cv.put(POST_ID, report.postId)
        cv.put(REPORT_DESCRIPTION, report.reportDesciprion)
        cv.put(REPORT_PHOTO, report.reportPhoto)
        cv.put(REPORT_TIMESTAMP, report.reportTimestamp)
        val result = db.insert(REPORT_TABLE, null, cv)
        if (result == (-1).toLong()){
            Toast.makeText(context, "Error submitting reported", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Report submitted successfully", Toast.LENGTH_SHORT).show()
        }
        db.close()
    }

    //Reading Data
    fun readAccount(accId: Int) : Account {
        var db = this.readableDatabase
        val select = "SELECT * FROM $ACCOUNT_TABLE WHERE $ACCOUNT_ID = $accId"
        val result = db.rawQuery(select, null)
        result.moveToFirst()
        return Account(result.getInt(0), result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6));
    }

    fun readMultiAccount() : MutableList<Account> {
        var db = this.readableDatabase
        var returnList: MutableList<Account> = ArrayList()
        val select = "SELECT * FROM $ACCOUNT_TABLE"
        val result = db.rawQuery(select, null)
        if(result.moveToFirst()){
            do {
                val account = Account(result.getInt(0),    result.getString(2), result.getString(4), result.getString(5))
                returnList.add(account)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return returnList
    }
    fun readMultiAccount(accId: Int) : MutableList<Account> {
        var db = this.readableDatabase
        var returnList: MutableList<Account> = ArrayList()
        val select = "SELECT * FROM $ACCOUNT_TABLE WHERE $ACCOUNT_ID = $accId"
        val result = db.rawQuery(select, null)
        if(result.moveToFirst()){
            do {
                val account = Account(result.getInt(0),    result.getString(2), result.getString(4), result.getString(5))
                returnList.add(account)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return returnList
    }


    fun readAccount() : MutableList<Account>{
        var db = this.readableDatabase
        var returnList: MutableList<Account> = ArrayList()
        val select = "SELECT * FROM $ACCOUNT_TABLE"
        val result = db.rawQuery(select, null)
        if (result.moveToFirst()){
            do {
                val account = Account(result.getInt(0),    result.getString(2), result.getString(4), result.getString(5))
                returnList.add(account)
            } while (result.moveToNext())
        }
        else {
         TODO("no content")
            Toast.makeText(context, "No Post", Toast.LENGTH_SHORT).show()
        }
        result.close()
        db.close()
        return returnList
    }

    fun readChat() : MutableList<Chat>{
        var db = this.readableDatabase
        var returnList: MutableList<Chat> = ArrayList()
        val select = "SELECT * FROM $CHAT_TABLE"
        val result = db.rawQuery(select, null)
        if (result.moveToFirst()){
            do {
                val chat = Chat(result.getInt(0),    result.getInt(1), result.getInt(2), result.getString(3), result.getString(4))
                returnList.add(chat)
            } while (result.moveToNext())
        }
        else {
            TODO("no content")
            Toast.makeText(context, "No Post", Toast.LENGTH_SHORT).show()
        }
        result.close()
        db.close()
        return returnList
    }

    fun readChat(accId: Int) : MutableList<Chat>{
        var db = this.readableDatabase
        var returnList: MutableList<Chat> = ArrayList()
        val select = "SELECT * FROM $CHAT_TABLE WHERE $ACCOUNT_ID_1 = $accId"
        val result = db.rawQuery(select, null)
        if (result.moveToFirst()){
            do {
                val chat = Chat(result.getInt(0),    result.getInt(1), result.getInt(2), result.getString(3), result.getString(4))
                returnList.add(chat)
            } while (result.moveToNext())
        }
        else {
            TODO("no content")
            Toast.makeText(context, "No Post", Toast.LENGTH_SHORT).show()
        }
        result.close()
        db.close()
        return returnList
    }

    fun readLastChat(acc1Id: Int) : MutableList<Chat>{
        var db = this.readableDatabase
        var returnList: MutableList<Chat> = ArrayList()
        val select = "SELECT * FROM $CHAT_TABLE WHERE $ACCOUNT_ID_1 = $acc1Id AND $ACCOUNT_ID_2 = (SELECT DISTINCT ($ACCOUNT_ID_2) FROM $CHAT_TABLE WHERE $ACCOUNT_ID_1 = $acc1Id) ORDER BY $CHAT_TIMESTAMP DESC"
        val result = db.rawQuery(select, null)
        if (result.moveToFirst()){
            var secondId : Int = -1
            do{
                var chat = Chat(result.getInt(0),    result.getInt(1), result.getInt(2), result.getString(3), result.getString(4))
                if (chat.accountId2 != secondId){
                    returnList.add(chat)
                }
                else {
                    secondId = chat.accountId2
                }
            }while (result.moveToNext())
        }
        else {
            TODO("no content")
            Toast.makeText(context, "No Post", Toast.LENGTH_SHORT).show()
        }
        result.close()
        db.close()
        return returnList
    }

    fun readComment(postId: Int) : MutableList<Comment>{
        var db = this.readableDatabase
        var returnList: MutableList<Comment> = ArrayList()
        val select = "SELECT * FROM $COMMENT_TABLE WHERE $POST_ID = $postId"
        val result = db.rawQuery(select, null)
        if (result.moveToFirst()){
            do {
                val comment = Comment(result.getInt(0),    result.getInt(1), result.getInt(2), result.getString(3))
                returnList.add(comment)
            } while (result.moveToNext())
        }
        else {
            TODO("no content")
            Toast.makeText(context, "No Post", Toast.LENGTH_SHORT).show()
        }
        result.close()
        db.close()
        return returnList
    }

    fun readCommentCount(postId: Int) : Int {
        val db = this.readableDatabase
        val select = "SELECT COUNT(DISTINCT $COMMENT_ID) FROM $COMMENT_TABLE WHERE $POST_ID = $postId"
        val result = db.rawQuery(select, null)
        if (result.moveToFirst()){
            return result.getInt(0)
        }
        else{
            return 0
        }
    }

    fun readLike() : MutableList<Like>{
        var db = this.readableDatabase
        var returnList: MutableList<Like> = ArrayList()
        val select = "SELECT * FROM " + LIKE_TABLE
        val result = db.rawQuery(select, null)
        if (result.moveToFirst()){
            do {
                val like = Like(result.getInt(0),    result.getInt(1), result.getInt(2))
                returnList.add(like)
            } while (result.moveToNext())
        }
        else {
            TODO("no content")
            Toast.makeText(context, "No Post", Toast.LENGTH_SHORT).show()
        }
        result.close()
        db.close()
        return returnList
    }

    fun readLikeCount(postId: Int) : Int {
        val db = this.readableDatabase
        val select = "SELECT COUNT(DISTINCT $LIKE_ID) FROM $LIKE_TABLE WHERE $POST_ID = $postId"
        val result = db.rawQuery(select, null)
        if (result.moveToFirst()){
            return result.getInt(0)
        }
        else{
            return 0
        }
    }

    fun readPost() : MutableList<Post>{
        var db = this.readableDatabase
        var returnList: MutableList<Post> = ArrayList()
        val select = "SELECT * FROM $POST_TABLE"
        val result = db.rawQuery(select, null)
        if (result.moveToFirst()){
            do {
                val post = Post(result.getInt(0),    result.getInt(1), result.getInt(2), result.getString(3), result.getString(4))
                returnList.add(post)
            } while (result.moveToNext())
        }
        else {
            TODO("no content")
            Toast.makeText(context, "No Post", Toast.LENGTH_SHORT).show()
        }
        result.close()
        db.close()
        return returnList
    }


    //Delete
    fun deleteAccount(accountId: Int){
        val db = this.writableDatabase
        val delete = "DELETE FROM $ACCOUNT_TABLE WHERE $ACCOUNT_ID = $accountId"
        val result = db.rawQuery(delete, null)
        if (result.moveToFirst()){
            Toast.makeText(context, "Delete success", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Error deleting", Toast.LENGTH_SHORT).show()
        }
        result.close()
        db.close()
    }


    fun deletePost(postId: Int){
        val db = this.writableDatabase
        val delete = "DELETE FROM $POST_TABLE WHERE $POST_ID = $postId"
        val result = db.rawQuery(delete, null)
        if (result.moveToFirst()){
            Toast.makeText(context, "Delete success", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Error deleting", Toast.LENGTH_SHORT).show()
        }
        result.close()
        db.close()
    }

    fun deleteComment(commentId: Int){
        val db = this.writableDatabase
        val delete = "DELETE FROM $COMMENT_TABLE WHERE $COMMENT_ID = $commentId"
        val result = db.rawQuery(delete, null)
        if (result.moveToFirst()){
            Toast.makeText(context, "Delete success", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Error deleting", Toast.LENGTH_SHORT).show()
        }
        result.close()
        db.close()
    }

}