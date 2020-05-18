open class Person {
  private var firstName:String
  private var lastName:String

  constructor(first:String, last:String) {
    firstName = first
    lastName = last
  }

  override fun toString():String {
    return "$lastName, $firstName"
  }
}