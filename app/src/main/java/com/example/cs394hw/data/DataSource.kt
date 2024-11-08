package com.example.cs394hw.data

import android.content.Context
import com.example.cs394hw.R
import com.example.cs394hw.model.Player

class DataSource(val context: Context) {
    fun getPlayerNamesList(): Array<String>{
        return context.resources.getStringArray(R.array.name_array)
    }
    fun getPlayerTeamsList(): Array<String>{
        return context.resources.getStringArray(R.array.teams_array)
    }
    fun getPlayerProfileList(): Array<String>{
        return context.resources.getStringArray(R.array.info_array)
    }

    fun loadUsers(): List<Player>{
        val namesList = getPlayerNamesList()
        val teamsList = getPlayerTeamsList()
        val profileList  = getPlayerProfileList()

        val players = mutableListOf<Player>()
        for (i in namesList.indices){
            players.add(Player(namesList[i],  profileList[i],  teamsList[i]))
        }
        return players
    }
}