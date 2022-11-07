package partners.moonshot.configpanel.domain

data class ConfigToggle(
    val name: String? = "",
    val isEnabled: Boolean? = true
)

data class Toggle(
    val name: String? = "", val isEnabled: Boolean? = true, val updateTimer: Long? = 0L
)

data class Key(
    val key: String? = ""
)