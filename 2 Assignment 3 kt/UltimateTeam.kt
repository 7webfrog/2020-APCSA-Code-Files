class UltimateTeam {
  private var players:ArrayList<UltimatePlayer>
  private var coaches:ArrayList<Coach>

  constructor(players:ArrayList<UltimatePlayer>, coaches:ArrayList<Coach>) {
    this.players = players
    this.coaches = coaches
  }

  fun getCutters():String {
    var out:String = ""
    for (e:UltimatePlayer in players) {
      if (e.getPosition().equals("cutter")) {
        out += "$e\n"
      }
    }
    return out
  }

  fun getHandlers():String {
    var out:String = ""
    for (e:UltimatePlayer in players) {
      if (e.getPosition().equals("handler")) {
        out += "$e\n"
      }
    }
    return out
  }

  override fun toString():String {
    var coaches:String = ""
    var players:String = ""
    for (e:Coach in this.coaches) {
      coaches += "$e\n"
    }
    for (e:UltimatePlayer in this.players) {
      players += "$e\n"
    }
    return "COACHES\n$coaches\nPLAYERS\n$players"
  }
}