package me.omarahmed.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.omarahmed.moreappslib.model.App
import me.omarahmed.moreappslib.ui.MoreAppsFragment

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        val apps = arrayListOf(
            App("me.azab.oa.powernap", "app 1", "https://i.imgur.com/DeAaYOb.jpg"),
            App("me.azab.oa.powernap", "app 2", "https://i.imgur.com/JBTdXWn.png"),
            App("me.azab.oa.powernap", "app 3", "https://i.imgur.com/jokfOtI.png"),
            App("me.azab.oa.powernap", "app 4", "https://i.imgur.com/JBTdXWn.png")
        )

        val fragment = MoreAppsFragment.getInstance(apps)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()

    }
}
