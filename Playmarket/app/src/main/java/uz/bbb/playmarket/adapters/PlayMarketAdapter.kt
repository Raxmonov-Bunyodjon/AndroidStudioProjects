package uz.bbb.playmarket.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bbb.playmarket.databinding.ItemPlayMarketBinding
import uz.bbb.playmarket.models.GeneralData



class PlayMarketAdapter(var generalList:List<GeneralData>):
    RecyclerView.Adapter<PlayMarketAdapter.Vh>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Vh {
        // ViewBinding orqali inflate
        val binding = ItemPlayMarketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Vh(binding)
    }

    override fun onBindViewHolder(
        holder: Vh,
        position: Int
    ) {
        holder.onBind(generalList[position])
    }

    override fun getItemCount(): Int = generalList.size


        inner class Vh(private val binding: ItemPlayMarketBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(generalData: GeneralData){
            binding.titleTv.text = generalData.title
            val inPlayMarketAdapter = InPlayMarketAdapter(generalData.appList!!)
            binding.rvInside.adapter = inPlayMarketAdapter
        }
    }

}