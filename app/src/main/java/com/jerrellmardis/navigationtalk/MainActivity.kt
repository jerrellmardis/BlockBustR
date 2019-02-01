package com.jerrellmardis.navigationtalk

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class WelcomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.login_button).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.welcome_to_returning_user_flow)
        }

        view.findViewById<View>(R.id.browse_button).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.welcome_to_browse)
        }
    }
}

class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.forgot_password_button).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.login_to_forgot_password)
        }
    }
}

class BrowseFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_browse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.movie_item).setOnClickListener {
            val extras = FragmentNavigator.Extras.Builder().let { builder ->
                val movieImageView: View = view.findViewById<ImageView>(R.id.movie_image)
                builder.addSharedElement(movieImageView, getString(R.string.image_transition))
                builder.build()
            }

            val description = it.findViewById<TextView>(R.id.movie_description).text.toString()

            val action = BrowseFragmentDirections.browseToMovieDetail(description)

            Navigation.findNavController(it).navigate(action, extras)
        }
    }
}

class MovieDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        sharedElementEnterTransition = TransitionInflater.from(activity)
            .inflateTransition(android.R.transition.move)
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            view.findViewById<TextView>(R.id.movie_description).text =
                MovieDetailFragmentArgs.fromBundle(it).movieDescription
        }
    }
}

class ForgotPassword : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_forgot_password, container, false)
    }
}
