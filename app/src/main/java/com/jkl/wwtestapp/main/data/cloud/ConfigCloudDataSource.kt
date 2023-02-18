package com.jkl.wwtestapp.main.data.cloud

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.jkl.wwtestapp.main.data.ConfigData
import kotlinx.coroutines.tasks.await

interface ConfigCloudDataSource {

    suspend fun config(): ConfigData

    class Base : ConfigCloudDataSource {
        override suspend fun config(): ConfigData {
            val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
            val configSettings = remoteConfigSettings { minimumFetchIntervalInSeconds = 0 }
            remoteConfig.setConfigSettingsAsync(configSettings)
            remoteConfig.fetchAndActivate().await()
            val status = remoteConfig.getBoolean("status")
            val link = remoteConfig.getString("link")
            return ConfigData(status, link)
        }
    }
}