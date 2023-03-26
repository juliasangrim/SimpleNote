package com.trubitsyna.homework

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.trubitsyna.homework.databinding.ViewContactBinding

class ViewContact @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defAttrsSet: Int = 0
) : ConstraintLayout(context, attributeSet, defAttrsSet) {
    private lateinit var viewBinding: ViewContactBinding

    init {
        viewBinding = ViewContactBinding.inflate(
            LayoutInflater.from(context),
            this, true
        )
        context.withStyledAttributes(
            attributeSet,
            R.styleable.ViewContact,
            defAttrsSet,
            0
        ) {
            getString(R.styleable.ViewContact_title)?.let {
                title -> viewBinding.textViewHeadline.text = title
            }
            getString(R.styleable.ViewContact_subtitle)?.let {
                subtitle -> viewBinding.textViewSubtitle.text = subtitle
            }
            getDrawable(R.styleable.ViewContact_image)?.let {
                drawable ->  viewBinding.imageViewProfile.setImageDrawable(drawable)
            }
        }
    }

    fun setTitle(text: String) {
        viewBinding.textViewHeadline.text = text
    }

    fun setSubtitle(text:String) {
        viewBinding.textViewSubtitle.text = text
    }

    fun setImage(@DrawableRes imagesRes: Int) {
        viewBinding.imageViewProfile.setImageDrawable(
            ContextCompat.getDrawable(context, imagesRes)
        )
    }
}