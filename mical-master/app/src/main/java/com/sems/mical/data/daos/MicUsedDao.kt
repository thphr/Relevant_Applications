package com.sems.mical.data.daos

import androidx.room.*
import com.sems.mical.data.entities.MicrophoneIsBeingUsed

@Dao
interface MicUsedDao {

    @Query("SELECT * FROM MicrophoneIsBeingUsed")
    fun getAll() : List<MicrophoneIsBeingUsed>

    @Query("SELECT * FROM MicrophoneIsBeingUsed WHERE fenceName == :name")
    fun getAllByFenceName(name: String) : List<MicrophoneIsBeingUsed>

    @Insert
    fun insert(app:MicrophoneIsBeingUsed)

    @Update
    fun update(app:MicrophoneIsBeingUsed)

    @Delete
    fun delete(app:MicrophoneIsBeingUsed)
}