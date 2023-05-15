package selectingImages.adapter
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selectingimeges.databinding.ItemImageLayoutBinding
import selectingImages.model.ImageModel
import selectingImages.ui.actitvity.MainActivity.Companion.selectedModeList

class ImageAdapter(private val click: Result): RecyclerView.Adapter<ImageAdapter.ViewHolder>(){

    private val list = ArrayList<Int>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Int>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemImageLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(imgModel: Int){
            binding.itemImg.setImageResource(list[imgModel])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemImageLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(position)

        holder.itemView.setOnClickListener {
            click.onClick(img = list[position])
            if (holder.itemView.alpha == 1f) {
                holder.itemView.alpha = 0.2f
            } else {
                holder.itemView.alpha = 1f
            }
        }
    }

    interface Result {
        fun onClick(img: Int)
    }
}