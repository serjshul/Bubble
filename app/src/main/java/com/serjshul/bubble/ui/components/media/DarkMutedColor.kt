package com.serjshul.bubble.ui.components.media

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.palette.graphics.Palette
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.utils.toARGBString
import okhttp3.internal.toHexString
import java.io.InputStream

@Composable
fun DarkMutedColor(
    uri: String?,
    onColorExtract: (String?) -> Unit
) {
    if (uri != null) {
        val bitmap = getBitmapFromUri(LocalContext.current, Uri.parse(uri))
        bitmap?.let {
            Palette.from(it).generate { palette ->
                val dominantColor = palette?.darkMutedSwatch?.rgb
                if (dominantColor != null) {
                    onColorExtract("#" + dominantColor.toHexString())
                } else {
                    onColorExtract(null)
                }
            }
        }
    } else {
        onColorExtract(md_theme_light_primary.toARGBString())
    }
}

fun getBitmapFromUri(context: Context, uri: Uri): Bitmap? {
    return try {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        BitmapFactory.decodeStream(inputStream)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}