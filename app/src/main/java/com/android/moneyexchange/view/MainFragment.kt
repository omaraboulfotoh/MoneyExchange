package com.android.moneyexchange.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import com.android.moneyexchange.R
import com.android.moneyexchange.databinding.FragmentMainBinding
import com.android.moneyexchange.view.adapter.CurrencyAdapter


@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val adapter: CurrencyAdapter by lazy {
        CurrencyAdapter {
            // TODO: 04/06/2021 handle action
        }
    }

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

        binding.rvCurrencies.adapter = adapter

    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
