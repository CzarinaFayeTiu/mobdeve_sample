package ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    //BEACUSE WE HAVE VIEW BINDING
    var binding: ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        //get the one passed using bundle
        var bundle = intent.extras
        var usernameBundle = bundle!!.getString("username_bundle")

        //get the one passed using Extra
        var usernameExtra = intent.getStringExtra("username_extra")

        Log.i("Home Activity", "Username from Bundle: $usernameBundle")
        Log.i("Home Activity", "Username from Extra: $usernameExtra")

        //no need to create the find view by id like the one in main activity
        binding!!.etMessage.text = "Hello"

    }
}