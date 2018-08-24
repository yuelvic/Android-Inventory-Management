package io.chaman.im.adapters

import androidx.annotation.Nullable
import androidx.recyclerview.selection.ItemKeyProvider
import androidx.recyclerview.widget.RecyclerView


internal class KeyProvider(adapter: RecyclerView.Adapter<*>)
    : ItemKeyProvider<Long>(ItemKeyProvider.SCOPE_MAPPED) {

    @Nullable
    override fun getKey(position: Int): Long? {
        return position.toLong()
    }

    override fun getPosition(key: Long): Int {
        return key.toInt()
    }
}
