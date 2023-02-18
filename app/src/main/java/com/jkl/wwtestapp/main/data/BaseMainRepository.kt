package com.jkl.wwtestapp.main.data

import com.jkl.wwtestapp.main.data.cache.ConfigCacheDataSource
import com.jkl.wwtestapp.main.data.cloud.ConfigCloudDataSource
import com.jkl.wwtestapp.main.domain.ConfigFact
import com.jkl.wwtestapp.main.domain.MainRepository

class BaseMainRepository(
    private val cloudDataSource: ConfigCloudDataSource,
    private val cacheDataSource: ConfigCacheDataSource,
    private val handleDataRequest: HandleDataRequest
) : MainRepository {

    override suspend fun config(): ConfigFact = handleDataRequest.handle {
        val result = cloudDataSource.config()
        cacheDataSource.saveLink(result)
        result
    }
}