package com.jerrellmardis.navigationtalk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

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

//        // start the nested graph login flow
//        view.findViewById<View>(R.id.login_button).setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.welcome_to_returning_user_flow)
//        }
//
//        // navigate to the BrowseFragment
//        view.findViewById<View>(R.id.browse_button).setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.welcome_to_browse)
//        }
    }
}

class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        // navigate to the ForgotPasswordFragment
//        view.findViewById<View>(R.id.forgot_password_button).setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.login_to_forgot_password)
//        }
    }
}

class BrowseFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_browse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        // navigate to the MovieDetailFragment and share the movie's image
//        view.findViewById<View>(R.id.movie_item).setOnClickListener {
//
//            // build the shared element extras
//            val extras = FragmentNavigator.Extras.Builder().let { builder ->
//
//                // get/find the ImageView which will be shared
//                val movieImageView: View = view.findViewById<ImageView>(R.id.movie_image)
//
//                // add the ImageView and transition name as a shared element pair
//                builder.addSharedElement(movieImageView, getString(R.string.image_transition))
//
//                // build the shared element extras
//                builder.build()
//            }
//
//            // get the movie's description from the description TextView
//            val description = it.findViewById<TextView>(R.id.movie_description).text.toString()
//
//            // build a Navigation action with the movie's description
//            val action = BrowseFragmentDirections.browseToMovieDetail(description)
//
//            // navigate to the MovieDetailFragment while using a shared element transition
//            Navigation.findNavController(it).navigate(action, extras)
//        }
    }
}

class MovieDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

//        // set the shared element enter transition using the stock "move" transition
//        sharedElementEnterTransition = TransitionInflater.from(activity)
//            .inflateTransition(android.R.transition.move)

        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        arguments?.let {
//
//            // parse the MovieDetailFragmentArgs bundle and set the movie description text
//            view.findViewById<TextView>(R.id.movie_description).text =
//                MovieDetailFragmentArgs.fromBundle(it).movieDescription
//        }
    }
}

class ForgotPassword : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_forgot_password, container, false)
    }
}
