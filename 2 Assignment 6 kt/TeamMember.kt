class TeamMember: Comparable<TeamMember> {
  private var fullName:String
  private var idString:String

  constructor(name:String, id:String) {
    fullName = name.substring(0, 1).toUpperCase() + name.substring(1, name.length).toLowerCase()
    for (i in 0..fullName.length-1) {
      if (fullName.get(i) == ' ') {
        fullName = fullName.substring(0, i+1) + fullName.substring(i+1, i+2).toUpperCase() + fullName.substring(i+2, fullName.length)
      }
    }
    idString = id
  }

  override fun toString():String {
    return fullName
  }

  override fun compareTo(other:TeamMember):Int {
    return when {
      idString.compareTo(other.idString) > 0 -> 1
      0 > idString.compareTo(other.idString) -> -1
      else -> 0
    }
  }
}