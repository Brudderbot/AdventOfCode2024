package io.brudderbot

import java.io.File

fun readFileAsText(fileName: String)
        = File(fileName).inputStream().readBytes().toString(Charsets.UTF_8)