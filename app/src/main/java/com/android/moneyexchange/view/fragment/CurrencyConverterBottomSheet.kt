package com.android.moneyexchange.view.fragment

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import com.android.moneyexchange.R
import com.android.moneyexchange.databinding.FragmentConverterBinding
import com.android.moneyexchange.models.Currency
import com.android.moneyexchange.utiles.RoundedBottomSheetDialogFragment
import com.android.moneyexchange.viewmodel.CurrencyViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CurrencyConverterBottomSheet : RoundedBottomSheetDialogFragment() {

    private var _binding: FragmentConverterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CurrencyViewModel by viewModels()

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    private val currency: Currency by lazy {
        arguments?.getSerializable(CURRENCY_KEY) as Currency
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheet = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val bottomView = View.inflate(context, R.layout.fragment_converter, null)
        _binding = FragmentConverterBinding.bind(bottomView)

        bottomSheet.setOnShowListener {
            bottomSheet.setContentView(binding.root)
            bottomSheetBehavior = BottomSheetBehavior.from(bottomView.parent as View)
            bottomSheetBehavior.peekHeight = BottomSheetBehavior.PEEK_HEIGHT_AUTO
            initView()
            bindViewModel()
        }
        return bottomSheet
    }

    private fun initView() {
        binding.currency = currency
        binding.executePendingBindings()
        binding.etEUR.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.toString().let {
                    if (it.isNullOrEmpty()) {
                        binding.etCurrency.setText("")
                    } else {
                        currency.rate?.let { rate ->
                            val number = it.toDouble()
                            binding.etCurrency.setText("${number * rate}")
                        }

                    }
                }
            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun bindViewModel() = with(viewModel) {

    }

    companion object {
        private const val CURRENCY_KEY = "CurrencyConverterBottomSheet.CURRENCY_KEY"
        fun newInstance(currency: Currency): CurrencyConverterBottomSheet {
            val fragment = CurrencyConverterBottomSheet()
            fragment.arguments = Bundle().apply {
                putSerializable(CURRENCY_KEY, currency)
            }
            return fragment
        }
    }


//    if (str.isNullOrEmpty()) {
//        binding.etCurrency.setText("")
//    } else {
//        currency.rate?.let {
//            val number = str.toDouble()
//            binding.etCurrency.setText("${number * it}")
//        }
//
//    }
}