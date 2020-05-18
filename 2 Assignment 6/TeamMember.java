/* Ryan Lutz
 * 10/22/19
 * M2A6
 */
public class TeamMember implements Comparable<TeamMember> {
  private String fullName; // Declare instantiation vars
  private String idString;

  public TeamMember(String name, String id) {
    int j=1; // Declare position var for first letter
    fullName = name.substring(0, 1).toUpperCase(); // Add the first letter to fullName as a capital letter
    for (int i=0; i<name.length(); i++) { // For each char in name
      if (name.charAt(i) == ' ' || name.charAt(i) == '\t') { // If the char at i is a space or tab
        fullName += name.substring(j, i+1).toLowerCase(); // Add the part of the string before it but after the previous tab/space to fullName
        fullName += name.substring(i+1, i+2).toUpperCase(); // Add the capital letter to fullName
        j=i+2; // Reset j
      }
    }
    if (j < name.length()) { // If a part of the string remains after the capital letters are added
      fullName += name.substring(j).toLowerCase(); // Add the rest of the string
    }
    idString = id; // Set the idString
  }

  public String toString() { // To String
    return fullName; // Return fullName
  }

  public int compareTo(TeamMember d) { // Compare To
    int output = idString.compareTo(d.idString); // Initialize output to the result of comparing the two idStrings
    return output == 0 ? output : output > 0 ? 1 : -1; // If output is 0, return 0, else if output is greater than 0, return 1, else return -1
  }
}