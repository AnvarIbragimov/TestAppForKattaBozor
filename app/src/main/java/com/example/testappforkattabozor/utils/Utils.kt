package com.example.testappforkattabozor.utils

import android.content.Context
import java.io.IOException

class Utils {

    companion object {

        fun getJsonFromAssets(context: Context, fileName: String): String {
            return try {

                val file = context.assets.open(fileName)

                val size = file.available()
                val buffer = ByteArray(size)
                file.read(buffer)
                file.close()

                String(buffer, Charsets.UTF_8)

            } catch (e: IOException) {
                e.printStackTrace()
                ""
            }
        }
    }
}