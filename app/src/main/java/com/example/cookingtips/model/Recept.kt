package com.example.cookingtips.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recept(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)
