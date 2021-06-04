package com.android.moneyexchange.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.moneyexchange.R
import com.android.moneyexchange.databinding.ItemCurrencyBinding
import com.android.moneyexchange.models.Currency
import com.android.moneyexchange.view.adapter.viewholder.CurrencyViewHolder

class CurrencyAdapter(private val onItemSelected: (Currency) -> Unit) :
    ListAdapter<Currency, RecyclerView.ViewHolder>(CurrencyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCurrencyBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_currency, parent, false
        )
        return CurrencyViewHolder(binding, onItemSelected)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as CurrencyViewHolder).bind(item)
    }

    class CurrencyDiffCallback : DiffUtil.ItemCallback<Currency>() {
        override fun areItemsTheSame(old: Currency, newItem: Currency) =
            old.code == newItem.code

        override fun areContentsTheSame(old: Currency, newItem: Currency) =
            old.rate == newItem.rate
    }
}