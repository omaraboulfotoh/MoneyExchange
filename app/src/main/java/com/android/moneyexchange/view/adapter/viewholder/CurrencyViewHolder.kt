package com.android.moneyexchange.view.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.android.moneyexchange.databinding.ItemCurrencyBinding
import com.android.moneyexchange.models.Currency

class CurrencyViewHolder(
    private val binding: ItemCurrencyBinding,
    private val onItemSelected: (Currency) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(currency: Currency) {
        binding.currency = currency
        binding.executePendingBindings()

        binding.root.setOnClickListener {
            onItemSelected(currency)
        }
    }
}