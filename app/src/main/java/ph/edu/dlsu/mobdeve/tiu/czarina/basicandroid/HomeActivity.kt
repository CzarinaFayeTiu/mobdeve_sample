package ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.databinding.ActivityHomeBinding
import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.model.User

class HomeActivity : AppCompatActivity() {

    //BEACUSE WE HAVE VIEW BINDING
    var binding: ActivityHomeBinding? = null
    var userAdapter: UserAdapter? = null //use to populate data
    var userList = ArrayList<User>() //contains the data


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        //get the one passed using bundle
       // var bundle = intent.extras
       // var usernameBundle = bundle!!.getString("username_bundle")

        //get the one passed using Extra
       // var usernameExtra = intent.getStringExtra("username_extra")

       // Log.i("Home Activity", "Username from Bundle: $usernameBundle")
       // Log.i("Home Activity", "Username from Extra: $usernameExtra")

        //populate the userList
        populateList()
        //declare user adapter
        userAdapter = UserAdapter(applicationContext, userList)
        //set layout manager of adapter - linear layout or grid layout
        binding!!.userList.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL, false)

        /*
        GRID LAYOUT
         binding!!.userList.layoutManager = GridLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL, false)
         */

        binding!!.userList.adapter = userAdapter

    }

    fun populateList(){
        userList.add(User("Tiu", "Czarina", "11111111"))
        userList.add(User("Ty", "Sam", "22222222"))
        userList.add(User("Magtibay", "Uri", "33333333"))
        userList.add(User("Avila", "Zoe", "44444444"))
        userList.add(User("Dorde", "Angel", "55555555"))

    }



}