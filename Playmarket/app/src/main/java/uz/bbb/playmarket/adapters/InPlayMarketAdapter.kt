package uz.bbb.playmarket.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.bbb.playmarket.databinding.ItemInPlayMarketBinding
import uz.bbb.playmarket.models.Program


class InPlayMarketAdapter(private val appList:List<Program>):
    RecyclerView.Adapter<InPlayMarketAdapter.Vh>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Vh {
        val binding = ItemInPlayMarketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Vh(binding)
    }

    override fun onBindViewHolder(
        holder: Vh,
        position: Int
    ) {
        holder.onBind(appList[position])
    }

    override fun getItemCount(): Int = appList.size

    inner class Vh(private val binding: ItemInPlayMarketBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(program: Program) {
            binding.appName.text = program.appName
            Picasso.get().load(program.imgUrl).into(binding.img)



        }
    }
}