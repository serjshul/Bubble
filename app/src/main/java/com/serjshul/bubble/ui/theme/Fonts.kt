package com.serjshul.bubble.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.serjshul.bubble.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val outfitFont = GoogleFont(name = "Outfit")
val outfitFontFamily = FontFamily(
    Font(googleFont = outfitFont, fontProvider = provider),
    Font(googleFont = outfitFont, fontProvider = provider, weight = FontWeight.Bold)
)