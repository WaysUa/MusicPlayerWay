package com.main.songs.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.main.songs.R
import com.main.songs.data.entities.AudioFile
import com.main.songs.databinding.ItemAudioFileBinding

class AudioFilesAdapter : RecyclerView.Adapter<AudioFilesAdapter.AudioFilesViewHolder>() {
    private val audioFiles = mutableListOf<AudioFile>()

    class AudioFilesViewHolder(view: View): ViewHolder(view) {
        private val binding by lazy { ItemAudioFileBinding.bind(view) }

        fun bind(audioFile: AudioFile) {
            binding.tvTItle.text = audioFile.title
            binding.tvArtist.text = audioFile.artist
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioFilesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_audio_file, parent, false)
        return AudioFilesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AudioFilesViewHolder, position: Int) {
        holder.bind(audioFiles[position])
    }

    override fun getItemCount() = audioFiles.size
}