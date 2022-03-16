package me.omarahmed.moreappslib.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.bumptech.glide.Glide
import me.omarahmed.moreappslib.databinding.ItemAppBinding
import me.omarahmed.moreappslib.model.App

class MoreAppsAdapter(
    private val apps: List<App>,
    private val onItemClick: (App) -> Unit
) :
    RecyclerView.Adapter<MoreAppsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemAppBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(apps[position])
    }

    override fun getItemCount(): Int = apps.size


    inner class ViewHolder(private val binding: ItemAppBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(app: App) {

            Glide.with(binding.img)
                .load(app.imageUrl)
                .into(binding.img)
        }

        override fun onClick(view: View?) {
            val position = adapterPosition
            if (position != NO_POSITION) {
                onItemClick(apps[position])
            }
        }

    }

}