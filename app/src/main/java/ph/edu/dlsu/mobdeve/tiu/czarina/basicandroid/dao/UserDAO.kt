package ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.dao

import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.model.User

interface UserDAO {

    fun addUser(user: User?): Long
    fun getUsers(): ArrayList<User?>?
    fun getUser(userid: Int): User?
    fun updateUser(user:User?):Int
    fun deleteUser(userid: Int):Int
}
