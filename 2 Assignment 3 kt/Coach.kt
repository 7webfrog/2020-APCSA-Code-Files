class Coach:Person {
  private var role:String

  constructor(firstName:String, lastName:String, role:String):super(firstName, lastName) {
    this.role = role
  }

  override fun toString():String {
    return "${super.toString()}\n   Role: $role"
  }
}