package com.jkl.wwtestapp.main.data.cloud

import com.jkl.wwtestapp.main.data.ConfigData
import com.jkl.wwtestapp.main.domain.ConfigFact

class ConfigDataToFact : ConfigData.Mapper<ConfigFact> {
    override fun map(status: Boolean, link: String): ConfigFact = ConfigFact(status, link)
}