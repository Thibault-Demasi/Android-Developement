package fr.isen.demasithibault.androiderestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.isen.demasithibault.androiderestaurant.databinding.FragmentAlreadyConnectedBinding

class AlreadyConnectedFragment : Fragment() {
    private lateinit var binding: FragmentAlreadyConnectedBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAlreadyConnectedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = (activity as AuthenticationActivity)?.getUser()

        binding.accountInformation.setText("Vous êtes connectés en tant que : " + "$name" + ". Voulez vous continuer ou changer de compte ?")
        binding.no.setOnClickListener{
            (activity as AuthenticationActivity)?.changeFragmentToLogin()
        }
        binding.yes.setOnClickListener{
            (activity as AuthenticationActivity)?.redirectToOrder()
        }
    }
}