package ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var et_username: EditText? = null
    var et_password: EditText?=null
    var btn_submit: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        btn_submit = findViewById(R.id.btn_submit)

        btn_submit!!.setOnClickListener {
            Log.i("MainActivity", "Username: ${et_username?.text}   Password ${et_password?.text}")

            Toast.makeText(applicationContext,
                "Username: ${et_username?.text}   Password: ${et_password?.text}",
                Toast.LENGTH_SHORT).show()

            var gotoHomeActivity = Intent(applicationContext, HomeActivity::class.java)

            //PUT ALL THE DATE YOU WANT TO PASS HERE IN BUNDLE
            var bundle = Bundle()
            //putstring is for items only
            bundle.putString("username_bundle", et_username!!.text.toString())
            gotoHomeActivity.putExtras(bundle)

            //putextra is for objects
            gotoHomeActivity.putExtra("username_extra", et_username!!.text.toString())

            startActivity(gotoHomeActivity)
            /*for example your in the login page then you
              press submit you are now in another page if there is
              finish() when the user press back they will be
              redirected to the home page else if wla siya
              babalik sa login page yun back*/
            finish()
        }
    }
}