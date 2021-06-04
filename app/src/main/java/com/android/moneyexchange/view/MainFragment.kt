package com.android.moneyexchange.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpNavigation()
    }

    private fun setUpNavigation() {

        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment

        binding.navigationBottom.setupWithNavController(navHostFragment.navController)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
