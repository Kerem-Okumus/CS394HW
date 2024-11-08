package com.example.cs394hw

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.cs394hw.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {
    companion object{
        const val PlayerName = "player_name"
        const val PlayerInfo = "player_info"
        const val PlayerTeam = "player_team"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_user_detail)
        val binding: ActivityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        val playerName = intent.getStringExtra(PlayerName)
        val playerInfo = intent.getStringExtra(PlayerTeam)
        val playerTeam = intent.getStringExtra(PlayerInfo)

        binding.nameView.text = playerName
        binding.teamView.text = playerTeam
        binding.profileView.text = playerInfo

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}