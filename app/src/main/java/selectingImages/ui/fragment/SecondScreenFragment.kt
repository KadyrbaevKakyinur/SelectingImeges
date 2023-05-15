package selectingImages.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selectingimeges.R
import com.example.selectingimeges.databinding.FragmentSecondScreenBinding
import selectingImages.adapter.ImageAdapter
import selectingImages.model.ImageModel
import selectingImages.ui.actitvity.MainActivity.Companion.selectedModeList

class SecondScreenFragment : Fragment(), ImageAdapter.Result {

    private lateinit var binding: FragmentSecondScreenBinding
    private val adapter: ImageAdapter by lazy {
        ImageAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondScreenBinding.inflate(layoutInflater,container , false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val list = arguments?.getIntegerArrayList("key")

            list?.let { adapter.setList(it) }
            binding.recyclerView.adapter = adapter

        }

        binding.itemBackScr.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.firstScreenFragment)
        }
    }

    override fun onClick(img: Int) {

    }


}