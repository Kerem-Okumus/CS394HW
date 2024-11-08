package com.example.cs394hw.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cs394hw.R
import com.example.cs394hw.UserDetailActivity
import com.example.cs394hw.model.Player

class ItemAdapter(private val data: List<Player>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var player: Player

        val nameView: TextView = view.findViewById(R.id.nameTV)
        val profileView: TextView = view.findViewById(R.id.profileTV)
        init {
            view.setOnClickListener{
                val context = itemView.context
                val showUserIntent = Intent(context, UserDetailActivity::class.java)
                showUserIntent.putExtra(UserDetailActivity.PlayerName, player.name)
                showUserIntent.putExtra(UserDetailActivity.PlayerTeam, player.playerTeam)
                showUserIntent.putExtra(UserDetailActivity.PlayerInfo, player.playerInfo)
                context.startActivity(showUserIntent)
            }
        }
        fun bind(player:Player){
            this.player = player
            nameView.text = player.name
            profileView.text = player.playerInfo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = data[position]
        holder.bind(user)

    }
}