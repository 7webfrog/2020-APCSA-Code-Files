class Board {
  private var squares:Array<Array<Char>>

  constructor() {
    squares = Array<Array<Char>>(10, {Array<Char>(10, {_ -> '-'})})
  }

  override fun toString():String {
    var out:String = ""
    for (row:Array<Char> in squares) {
      for (e:Char in row) {
        out += e + " "
      }
      out += "\n"
    }
    return out
  }

  fun addShip(row:Int, col:Int, len:Int, horizontal:Boolean):Boolean {
    when (horizontal) {
      true -> {
        if (col+len > 10) {
          return false
        }
        for (i in 0..len-1) {
          if (squares[row][col+i] == '-') {
            squares[row][col+i] = 'b'
          } else {
            for (j in 0..i-1) {
              squares[row][col+j] = '-'
              return false
            }
          }
        }
      }
      false -> {
        if (row+len > 10) {
          return false
        }
        for (i in 0..len-1) {
          if (squares[row+i][col] == '-') {
            squares[row+i][col] = 'b'
          } else {
            for (j in 0..i-1) {
              squares[row+j][col] = '-'
            }
            return false
          }
        }
      }
    }
    return true
  }

  fun shoot(row:Int, col:Int):Int {
    when {
      row > 9 || col > 9 -> return -1
      squares[row][col] == 'm' || squares[row][col] == 'x' -> return 2
      squares[row][col] == '-' -> {
        squares[row][col] = 'm'
        return 0
      }
      squares[row][col] == 'b' -> {
        squares[row][col] = 'x'
        return 1
      }
    }
    return -1
  }

  fun gameOver():Boolean {
    for (row:Array<Char> in squares) {
      for (e:Char in row) {
        if (e == 'b') {
          return false
        }
      }
    }
    return true
  }

  fun foundShip(len:Int):Boolean {
    val tempSquares:Array<Array<Char>> = Array<Array<Char>>(10, {_ -> Array<Char>(10, {_ -> '-'})})
    for (i in 0..9) {
      for (j in 0..9) {
        tempSquares[i][j] = squares[i][j]
      }
    }
    for (i in 0..9) {
      for (j in 0..9) {
        if (tempSquares[i][j] == 'b' && j != 9 && tempSquares[i][j+1] == 'b') { // If square at [i][j] is a ship
          tempSquares[i][j] = '-' // Reset the sqaure so it doesn't trigger another event
          tempSquares[i][j+1] = '-'
          var found:Int = 2 // Already found 2 ships, looking for more
          for (k in j+2..9) { // For every element left in the row starting with 2 after j
            if (tempSquares[i][k] == 'b') { // If that square is also a ship
              tempSquares[i][k] = '-' // Reset the sqaure so it doesn't trigger another event
              found++ // Increment found
            } else { // If next square isn't a ship
              println("Found horiz ship, length $found")
              break // Break the loop
            }
          }
          if (found == len) { // After the loop completes, if the found ship matches specified length, return true
            return true
          }
        } else if (tempSquares[i][j] == 'b' && i != 9 && tempSquares[i+1][j] == 'b') { // If square below is also a ship
          tempSquares[i][j] = '-' // Reset the sqaure so it doesn't trigger another event
          tempSquares[i+1][j] = '-'
          var found:Int = 2 // Already found 2 ships, looking for more
          for (k in i+2..9) { // For every element left in the column starting with 2 after i
            if (tempSquares[k][j] == 'b') { // If that square is also a ship
              tempSquares[k][j] = '-' // Reset the sqaure so it doesn't trigger another event
              found++ // Increment found
            } else { // If next square isn't a ship
              println("Found vert ship, length $found")
              break // Break the loop
            }
          }
          if (found == len) { // After the loop completes, if the found ship matches specified length, return true
            return true
          }
        } else if (tempSquares[i][j] == 'b') { // Otherwise
          tempSquares[i][j] == '-' // Reset the square so it doesn't trigger another event
          if (len == 1) { // If length is 1
            return true
          }
        }
      }
    }
    return false // If all else fails, return false
  }
}