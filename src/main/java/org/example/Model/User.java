package org.example.Model;

/**
instead of creating a class and overriding equals , hashcode and toString ,
 Java offers the record type ,
 which is like a class except that it comes with Overriden Equals(),hashcode() and ToString()  ,
 almost like Kotlin's data class and C# record
 * @param Email the user's email address
 * @param Password the user's password
 */
public record User(String Email, String Password) {
}
