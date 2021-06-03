 package com.android.recyclerview_custom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerview_custom.R
import com.android.recyclerview_custom.model.BlogPost
import com.bumptech.glide.Glide

class BlogPostAdapter(private val listBlog: ArrayList<BlogPost>, val context: Context) :
    RecyclerView.Adapter<BlogPostAdapter.BlogPostViewHolder>() {


    class BlogPostViewHolder constructor(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val blogImage: ImageView = itemView!!.findViewById(R.id.blog_image)
        val blogTitle: TextView = itemView!!.findViewById(R.id.blog_title)
        val blogAuthor: TextView = itemView!!.findViewById(R.id.blog_author)
        var blogContent: TextView = itemView!!.findViewById(R.id.blog_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogPostViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_blogpost, parent, false)
        return BlogPostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BlogPostViewHolder, position: Int) {
        val blogPost = listBlog[position]
        holder.blogAuthor.text = blogPost.username
        holder.blogTitle.text = blogPost.title
        holder.blogContent.text = blogPost.body
        Glide.with(context).load(blogPost.image).into(holder.blogImage)
    }

    override fun getItemCount(): Int {
        return listBlog.size
    }
}
