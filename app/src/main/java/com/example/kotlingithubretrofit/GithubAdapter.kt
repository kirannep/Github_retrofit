package com.example.kotlingithubretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlingithubretrofit.models.GithubRepo
import kotlinx.android.synthetic.main.row.view.*

class GithubAdapter(private val githubRepo: List<GithubRepo>) : RecyclerView.Adapter<GithubAdapter.GithubViewHoler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHoler {
      return GithubViewHoler(LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false))
    }

    override fun getItemCount(): Int {
        return githubRepo.size
    }

    override fun onBindViewHolder(holder: GithubViewHoler, position: Int) {
        holder.tvTitle.text = githubRepo[position].full_name
        holder.tvDescription.text = githubRepo[position].description
    }


    class GithubViewHoler(view: View) :RecyclerView.ViewHolder(view){
        val tvTitle = view.tv_title
        val tvDescription = view.tv_description
    }
}