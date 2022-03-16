package me.omarahmed.moreappslib.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri


fun Context.goToPlayStore(applicationId: String) {
    val uri = Uri.parse("market://details?id=$applicationId")
    val goToMarket = Intent(Intent.ACTION_VIEW, uri)
    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
    try {
        startActivity(goToMarket)
    } catch (e: ActivityNotFoundException) {
        val webUri = Uri.parse("http://play.google.com/store/apps/details?id=$applicationId")
        val webIntent = Intent(Intent.ACTION_VIEW, webUri)
        startActivity(webIntent)
    }
}