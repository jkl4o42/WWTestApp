package com.jkl.wwtestapp.main.domain

import com.jkl.wwtestapp.main.presentation.ConfigUi

class ConfigUiMapper : ConfigFact.Mapper<ConfigUi> {
    override fun map(status: Boolean, link: String): ConfigUi = ConfigUi(status, link)
}