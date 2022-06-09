package com.bitwisor.epoxyexperiment.adapter


import android.content.Context
import com.airbnb.epoxy.EpoxyController
import com.bitwisor.epoxyexperiment.DataClass.Article
import com.bitwisor.epoxyexperiment.DataClass.MyDataClass
import com.bitwisor.epoxyexperiment.R
import com.bitwisor.epoxyexperiment.databinding.CardViewDesignBinding
import com.bitwisor.epoxyexperiment.databinding.FooterlayoutBinding
import com.bitwisor.epoxyexperiment.databinding.HeaderlayoutBinding
import com.bitwisor.epoxyexperiment.epoxy.ViewBindingKotlinModel
import com.bumptech.glide.Glide

class HomeFragmentEpoxyController (val ccontext: Context): EpoxyController(){


    var mList = ArrayList<Article>()
    set(value){
        field = value
        requestModelBuild()
    }
    override fun buildModels() {
        HeaderEpoxyModel("This is sample header").id("header_1").addTo(this)
            mList.forEach {
                MyEpoxyModel(it,ccontext)
                    .id(it.title)
                    .addTo(this)
            }
        FooterEpoxyModel("This is sample Footer").id("header_2").addTo(this)

    }
    data class MyEpoxyModel(
        val item:Article,
        val context: Context
    ):ViewBindingKotlinModel<CardViewDesignBinding>(R.layout.card_view_design){
        override fun CardViewDesignBinding.bind() {
            mtextview.text = item.title
            Glide.with(context)
                .load(item.urlToImage)
            .into(imageview)
        }
    }

    data class HeaderEpoxyModel(
        val headertxt:String
    ):ViewBindingKotlinModel<HeaderlayoutBinding>(R.layout.headerlayout){
        override fun HeaderlayoutBinding.bind() {
            headertextView.text = headertxt
        }

    }
    data class FooterEpoxyModel(
        val footertxt:String
    ):ViewBindingKotlinModel<FooterlayoutBinding>(R.layout.footerlayout){
        override fun FooterlayoutBinding.bind() {
            footertextview.text = footertxt
        }

    }

}