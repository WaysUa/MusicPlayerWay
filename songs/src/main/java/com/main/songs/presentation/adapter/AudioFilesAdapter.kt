package com.main.songs.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.main.songs.R
import com.main.core.entities.AudioFile
import com.main.songs.databinding.ItemAudioFileBinding
import com.main.songs.domain.mapper.AudioFilesMapper

class AudioFilesAdapter(
    private val audioFilesAdapterClickListener: AudioFilesAdapterClickListener
) : RecyclerView.Adapter<AudioFilesAdapter.AudioFilesViewHolder>(), AudioFilesMapper {
    private val audioFiles = mutableListOf<AudioFile>()

    class AudioFilesViewHolder(view: View): ViewHolder(view) {
        private val binding by lazy { ItemAudioFileBinding.bind(view) }

        fun bind(
            audioFile: AudioFile, audioFilesMapper: AudioFilesMapper,
            audioFilesAdapterClickListener: AudioFilesAdapterClickListener
        ) {
            binding.tvTitle.text = audioFilesMapper.mapTextLength(20, audioFile.title)
            binding.tvArtist.text = audioFilesMapper.mapTextLength(20, audioFile.artist)
            binding.itemAudioFile.setOnClickListener { audioFilesAdapterClickListener.clickAudioFile(audioFile) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioFilesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_audio_file, parent, false)
        return AudioFilesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AudioFilesViewHolder, position: Int) {
        holder.bind(audioFiles[position], this, audioFilesAdapterClickListener)
    }

    override fun getItemCount() = audioFiles.size

    @SuppressLint("NotifyDataSetChanged")
    override fun mapAudioFiles(audioFiles: List<AudioFile>) {
        this.audioFiles.addAll(audioFiles)
        notifyDataSetChanged()
    }

    override fun mapTextLength(length: Int, text: String): String {
        return if (text.length > length) "${text.substring(0, length)}..." else text
    }
}

interface AudioFilesAdapterClickListener {
    fun clickAudioFile(audioFile: AudioFile)
}