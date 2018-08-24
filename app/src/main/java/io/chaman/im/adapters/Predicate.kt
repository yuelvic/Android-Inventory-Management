package io.chaman.im.adapters

import androidx.recyclerview.selection.SelectionTracker

internal class Predicate: SelectionTracker.SelectionPredicate<Long>() {
    override fun canSelectMultiple(): Boolean {
        return true
    }

    override fun canSetStateForKey(key: Long, nextState: Boolean): Boolean {
        return true
    }

    override fun canSetStateAtPosition(position: Int, nextState: Boolean): Boolean {
        return true
    }
}