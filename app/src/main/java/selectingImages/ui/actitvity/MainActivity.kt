package selectingImages.ui.actitvity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.selectingimeges.R
import com.example.selectingimeges.databinding.ActivityMainBinding
import selectingImages.model.ImageModel

class MainActivity : AppCompatActivity() {

     lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    companion object{
        var selectedModeList = mutableListOf<ImageModel>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController




    }


}