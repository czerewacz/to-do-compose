package com.example.to_do_list.data.models

import com.example.to_do_list.ui.theme.HighPriorityColor
import com.example.to_do_list.ui.theme.LowPriorityColor
import com.example.to_do_list.ui.theme.MediumPriorityColor
import com.example.to_do_list.ui.theme.NonePriorityColor

enum class Priority(val color: androidx.compose.ui.graphics.Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}