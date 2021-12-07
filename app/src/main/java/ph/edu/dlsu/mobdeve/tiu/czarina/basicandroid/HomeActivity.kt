package ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.dao.UserDAO
import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.dao.UserDAOArrayList
import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.databinding.ActivityHomeBinding
import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.model.User

class HomeActivity : AppCompatActivity() {

    //BEACUSE WE HAVE VIEW BINDING
    var binding: ActivityHomeBinding? = null
    var userAdapter: UserAdapter? = null //use to populate data
    var userList = ArrayList<User?>() //contains the data
    var userDAO: UserDAO = UserDAOArrayList()

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

        //populate the userList before using adopter
        populateList()
        //declare user adapter
        userAdapter = UserAdapter(applicationContext, userList!!)
        var itemTouchHelper = ItemTouchHelper(SwipeCallback(userAdapter!!))
        itemTouchHelper.attachToRecyclerView(binding!!.userList)


        //set layout manager of adapter - linear layout or grid layout
        binding!!.userList.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL, false)

        /*
        GRID LAYOUT
         binding!!.userList.layoutManager = GridLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL, false)
         */

        binding!!.userList.adapter = userAdapter

        binding!!.saveRecord.setOnClickListener{
            var user = User(binding!!.tvUsername.text.toString(),
                binding!!.tvUserlastname.text.toString(),
                binding!!.tvUserid.text.toString())

            userAdapter!!.addUser(user)
        }

    }

    fun populateList(){
        userList = userDAO.getUsers()!!

    }



}