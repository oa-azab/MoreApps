package me.omarahmed.moreappslib.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_more_apps.*
import me.omarahmed.moreappslib.R
import me.omarahmed.moreappslib.model.App
import me.omarahmed.moreappslib.util.goToPlayStore

class MoreAppsFragment : Fragment(R.layout.fragment_more_apps) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apps = arguments?.getParcelableArrayList<App>(ARGS_APPS)
            ?: throw Exception("App list must not be null")

        val moreAppsAdapter = MoreAppsAdapter(apps) { app ->
            context?.goToPlayStore(app.id)
        }
        rvMoreApps.layoutManager = LinearLayoutManager(requireContext())
        rvMoreApps.adapter = moreAppsAdapter
    }

    companion object {

        private const val ARGS_APPS = "args_apps"

        fun getInstance(apps: ArrayList<App>): MoreAppsFragment {
            return MoreAppsFragment().apply {
                arguments = Bundle().apply { putParcelableArrayList(ARGS_APPS, apps) }
            }
        }

    }

}