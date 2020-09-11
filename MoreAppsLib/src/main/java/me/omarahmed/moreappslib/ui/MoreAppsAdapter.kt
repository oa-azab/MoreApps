package me.omarahmed.moreappslib.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_app.*
import me.omarahmed.moreappslib.R
import me.omarahmed.moreappslib.model.App
import me.omarahmed.moreappslib.util.inflate

class MoreAppsAdapter(
    private val apps: List<App>,
    private val onItemClick: (App) -> Unit
) :
    RecyclerView.Adapter<MoreAppsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_app))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(apps[position])
    }

    override fun getItemCount(): Int = apps.size


    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer, View.OnClickListener {

        init {
            containerView.setOnClickListener(this)
        }

        fun bind(app: App) {

            Glide.with(img)
                .load(app.imageUrl)
                .into(img)
        }

        override fun onClick(view: View?) {
            val position = adapterPosition
            if (position != NO_POSITION) {
                onItemClick(apps[position])
            }
        }

    }

}