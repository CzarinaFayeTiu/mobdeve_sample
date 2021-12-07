package ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.dao

import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.model.User

class UserDAOArrayList : UserDAO{

    private var userList = ArrayList<User?>()

    init{
        userList.add(User("Tiu", "Czarina", "11111111"))
        userList.add(User("Ty", "Sam", "22222222"))
        userList.add(User("Magtibay", "Uri", "33333333"))
        userList.add(User("Avila", "Zoe", "44444444"))
        userList.add(User("Dorde", "Angel", "55555555"))
    }


    override fun addUser(user: User?): Long {
        userList.add(user!!)
        return 1L //return long is like for the userID pag gumamit na ng database
    }

    override fun getUsers(): ArrayList<User?>? = userList

    override fun getUser(userid: Int): User? {
        TODO("Not yet implemented")
    }

    override fun updateUser(user: User?): Int {
        TODO("Not yet implemented")
    }

    override fun deleteUser(userid: Int): Int {
        TODO("Not yet implemented")
    }

}