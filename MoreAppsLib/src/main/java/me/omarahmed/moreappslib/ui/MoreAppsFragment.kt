package me.omarahmed.moreappslib.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import me.omarahmed.moreappslib.R
import me.omarahmed.moreappslib.databinding.FragmentMoreAppsBinding
import me.omarahmed.moreappslib.model.App
import me.omarahmed.moreappslib.util.goToPlayStore

class MoreAppsFragment : Fragment(R.layout.fragment_more_apps) {

    private var _binding: FragmentMoreAppsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreAppsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apps = arguments?.getParcelableArrayList<App>(ARGS_APPS)
            ?: throw Exception("App list must not be null")

        val moreAppsAdapter = MoreAppsAdapter(apps) { app ->
            context?.goToPlayStore(app.id)
        }
        binding.rvMoreApps.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMoreApps.adapter = moreAppsAdapter
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
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