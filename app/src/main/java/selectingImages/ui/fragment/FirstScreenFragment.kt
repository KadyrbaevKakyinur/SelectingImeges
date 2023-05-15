package selectingImages.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.selectingimeges.R
import com.example.selectingimeges.databinding.FragmentFirstScreenBinding
import selectingImages.adapter.ImageAdapter
import selectingImages.model.ImageModel

class FirstScreenFragment : Fragment(), ImageAdapter.Result {

    private lateinit var binding: FragmentFirstScreenBinding
    private lateinit var adapter: ImageAdapter
    val images = ArrayList<Int>()
    val selectedList = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initClick()
    }

    private fun initClick() {
        binding.itemBtnNextScr.setOnClickListener {
            val bundle = Bundle()
            bundle.putIntegerArrayList("key", images)
            findNavController().navigate(R.id.secondScreenFragment, bundle)
        }
    }

    private fun initAdapter() {
        adapter = ImageAdapter(this)
        selectedList.add(R.drawable.img)
        selectedList.add(R.drawable.img_2)
        selectedList.add(R.drawable.img_3)
        selectedList.add(R.drawable.img)
        selectedList.add(R.drawable.img_3)
        selectedList.add(R.drawable.img_2)
        selectedList.add(R.drawable.img_3)
        selectedList.add(R.drawable.img)
        adapter.setList(selectedList)
        binding.recyclerView.adapter = adapter
    }

    override fun onClick(img: Int) {
        if (images.remove(img)) {
            images.remove(img)
        } else {
            images.add(img)
        }
    }
}
