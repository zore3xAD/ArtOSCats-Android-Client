package com.android.zore3x.artoscats.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.zore3x.artoscats.R
import com.android.zore3x.artoscats.model.Cat
import kotlinx.android.synthetic.main.card_item_cats.view.*

class CatAdapter : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    interface CatClickListener {
        fun OnClick(view: View, position: Long)
    }

    var catClickListener: CatClickListener? = null
    var data: MutableList<Cat> = ArrayList()
        set(value) {
            data.clear()
            data.addAll(value)
            notifyDataSetChanged()
        }

    fun setOnClickListener(listener: CatClickListener) {
        this.catClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CatViewHolder =
        CatViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.card_item_cats, parent, false))


    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: CatViewHolder?, position: Int) {
        holder?.bind(data[position])
    }

    inner class CatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            catClickListener?.OnClick(v!!, data[adapterPosition].id)
        }

        fun bind(cat: Cat) {
            itemView.catName_cardItem.text = cat.name
            itemView.catAge_cardItem.text = cat.age.toString()
        }

    }
}