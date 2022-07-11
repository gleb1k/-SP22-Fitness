package com.example.fitness.profile.moreprofile

import com.example.fitness.R
import com.example.fitness.profile.ProfileInfo

object MoreProfileInfoRepository {
    val infoList = arrayListOf<MoreProfileInfo>(
        MoreProfileInfo(
            id = 0,
            name="Сколько сигарет в день вы выкуриваете?",
            value = "",
            icon = R.drawable.ic_baseline_smoke_free_24,
            url = ""
        ),
        MoreProfileInfo(
            id = 1,
            name = "Сколько литров алкоголя в месяц вы употребляете?",
            value = "",
            icon = R.drawable.ic_baseline_no_drinks_24,
            url = ""
        ),
        MoreProfileInfo(
            id = 2,
            name = "Сколько стаканов воды в день вы употребляете?(1 стакан=240мл)",
            value = "",
            icon = R.drawable.ic_baseline_local_drink_24,
            url = ""
        )
    )
}