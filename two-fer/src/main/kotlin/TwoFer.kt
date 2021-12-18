internal fun twofer(name: String?=null): String {
    if(name.isNullOrEmpty())
        return "One for you, one for me."
    else
        return "One for $name, one for me."
}

