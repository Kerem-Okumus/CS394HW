package com.example.cs394hw

import android.os.Bundle

import android.view.View

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

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

        val layout = findViewById<View>(R.id.main)
        val backgroundColor = when (playerTeam) {
            "Los Angeles Lakers" -> ContextCompat.getColor(this, R.color.lakers1)
            "Golden State Warriors" -> ContextCompat.getColor(this, R.color.gsw1)
            "Phoenix Suns" -> ContextCompat.getColor(this, R.color.phnx2)
            "Denver Nuggets" -> ContextCompat.getColor(this, R.color.denver1)
            "Houston Rockets" -> ContextCompat.getColor(this, R.color.houston1)
            "Boston Celtics" -> ContextCompat.getColor(this, R.color.boston1)
            "Dallas Mavericks" -> ContextCompat.getColor(this, R.color.dallas1)
            "Minnesota Timberwolves" -> ContextCompat.getColor(this, R.color.mine1)
            else -> ContextCompat.getColor(this, R.color.dallas2)
        }
        val playerTeams = intent.getStringExtra(PlayerTeam)

        layout.setBackgroundColor(backgroundColor)

    }
}