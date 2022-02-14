package fr.isen.demasithibault.androiderestaurant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import fr.isen.demasithibault.androiderestaurant.databinding.ActivityAuthenticationBinding

class AuthenticationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthenticationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, SignupFragment()).commit()

        val userID = getSharedPreferences("IdSaving", Context.MODE_PRIVATE).getString("mail", "").toString()
        if(userID != "") {
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView, AlreadyConnectedFragment()).commit()
        }
    }

    fun changeFragmentToLogin(){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, LoginFragment()).commit()
    }

    fun changeFragmentToSignUp(){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,SignupFragment()).commit()
    }

    fun saveId (id : String, firstname : String, lastname: String){
        val sharedPreferences = getSharedPreferences("IdSaving", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("id_user", id)
        editor.putString("firstname", firstname)
        editor.putString("lastname", lastname)
        editor.apply()
        editor.commit()
    }

    fun redirectToOrder(){
        val intent =  Intent(this,OrderActivity::class.java)
        startActivity(intent)
    }

    fun getUser() : String{
        var name = getSharedPreferences("IdSaving", Context.MODE_PRIVATE).getString("lastname","").toString()
        var firstName  = getSharedPreferences("IdSaving", Context.MODE_PRIVATE).getString("firstname","").toString()
        return "$name" + "$firstName"
    }

}