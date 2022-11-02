package partners.moonshot.configpanel.domain

data class Toggle(
    val id: String, val name: String, val isEnabled: Boolean, val updateTimer: Long? = 0L
)

data class Key(
    val key: String
)