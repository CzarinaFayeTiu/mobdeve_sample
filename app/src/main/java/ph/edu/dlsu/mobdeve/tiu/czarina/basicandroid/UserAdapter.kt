package ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.databinding.ActivityHomeBinding
import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.databinding.ItemRowUserBinding
import ph.edu.dlsu.mobdeve.tiu.czarina.basicandroid.model.User

//Adopter populates the information per row
class UserAdapter(private val context: Context,
                  private var userList:ArrayList<User?>?)
    :RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val itemBinding = ItemRowUserBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = userList!!.size

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.bindUser(userList!![position]!!)
    }

    fun addUsers(usersArrayList: ArrayList<User?>?){
        userList!!.clear()
        userList!!.addAll(usersArrayList!!) //add everything from DAO i.e start of app
        notifyDataSetChanged()//very important if wla ito it wont update
    }

    fun addUser(user: User?){
        userList!!.add(0, user) //add single user
        notifyItemInserted(0)
        notifyDataSetChanged()
    }

    fun removeUser(position: Int) {
        userList!!.removeAt(position)
        notifyItemInserted(position)
        notifyDataSetChanged() //recreates the list with the new changes
    }

    /*
    send data of user in item_row_user.xml
    */
    class ViewHolder(private val itemBinding: ItemRowUserBinding)
        :RecyclerView.ViewHolder(itemBinding.root){

            fun bindUser(user:User){
                itemBinding.textfistname.text = user.firstname
                itemBinding.textlastname.text = user.lastname
                itemBinding.textid.text = user.id

            }
        }
}