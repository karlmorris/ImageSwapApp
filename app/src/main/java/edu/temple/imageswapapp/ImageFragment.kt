package edu.temple.imageswapapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlin.random.Random

class ImageFragment : Fragment() {

    private lateinit var imageView: ImageView

    lateinit var images : IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        images = arguments?.getIntArray("images")!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false).apply {
            imageView = findViewById(R.id.imageView)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeImage()

        view.findViewById<ImageView>(R.id.imageView).setOnClickListener {
            changeImage()
        }
    }

    fun changeImage () {
        imageView.setImageResource(images.random())
    }

    companion object {
        fun newInstance (images: IntArray) : ImageFragment {
            return ImageFragment().apply {
                arguments = Bundle().apply {
                    putIntArray("images", images)
                }
            }
        }
    }

}




