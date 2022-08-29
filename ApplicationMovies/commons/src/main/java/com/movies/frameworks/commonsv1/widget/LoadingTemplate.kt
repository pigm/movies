package com.movies.frameworks.commonsv1.widget

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.movies.frameworks.commonsv1.R
import com.movies.frameworks.commonsv1.databinding.TemplateLoadingBinding

class LoadingTemplate(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private var binding: TemplateLoadingBinding

    init {
        val view = ConstraintLayout.inflate(context, R.layout.template_loading, this)
        binding = TemplateLoadingBinding.bind(view)
        obtainStyledAttributes(attrs)
    }

    private fun obtainStyledAttributes(attrs: AttributeSet?) {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.LoadingTemplate)
        try {
            val messageAttr = attributes.getString(R.styleable.LoadingTemplate_loadingMessage)
            val colorAttr = attributes.getColor(
                R.styleable.LoadingTemplate_loadingBackgroundColor,
                ContextCompat.getColor(context, R.color.white)
            )
            setText(messageAttr)
            setBackgroundColor(colorAttr)
        } finally {
            attributes.recycle()
        }
    }

    fun setAttributes(text: String? = null, backgroundColor: Int? = null) {
        setText(text)
        setBackgroundColor(backgroundColor)
    }

    private fun setText(text: String?) {
        binding.loadingText.text = text
    }

    private fun setBackgroundColor(backgroundColor: Int?) {
        backgroundColor?.let { rootView.setBackgroundColor(backgroundColor) }
    }
}