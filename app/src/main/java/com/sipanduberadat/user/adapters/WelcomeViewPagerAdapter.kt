package com.sipanduberadat.user.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.sipanduberadat.user.R
import kotlinx.android.synthetic.main.fragment_welcome_view_pager.view.*

class WelcomeViewPagerAdapter(
    private val context: Context,
    private val images: Array<Int>,
    private val titles: Array<String>,
    private val descriptions: Array<String>
): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_welcome_view_pager,
            container, false)
        view.view_pager_image.setImageResource(images[position])
        view.view_pager_title.text = titles[position]
        view.view_pager_description.text = descriptions[position]

        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        return container.removeView(`object` as LinearLayout)
    }

}