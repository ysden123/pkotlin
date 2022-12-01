/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.pkotlin.serialization.data

import kotlinx.serialization.Serializable

@Serializable
data class Project(val name: String, val language: String)