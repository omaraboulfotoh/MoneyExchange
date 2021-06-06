package com.android.moneyexchange.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import com.android.moneyexchange.databinding.FragmentMainBinding
import com.android.moneyexchange.extention.observe
import com.android.moneyexchange.view.adapter.CurrencyAdapter
import com.android.moneyexchange.viewmodel.CurrencyViewModel


@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CurrencyViewModel by viewModels()

    private val adapter: CurrencyAdapter by lazy {
        CurrencyAdapter {
            val bottomSheet: CurrencyConverterBottomSheet =
                CurrencyConverterBottomSheet.newInstance(it)
            bottomSheet.show(childFragmentManager, "tag")
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
        bindViewModel()
    }

    private fun bindViewModel() = with(viewModel) {
        observe(loadCurrencies()) {
            if (it.size > 0) {
                adapter.submitList(it)
            } else {

            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
