package practice.adhoc

/**
 * HTML entity parser is the parser that takes HTML code as input and replace
 * all the entities of the special characters by the characters itself.
 *
 * The special characters and their entities for HTML are:
 * -    Quotation Mark: the entity is &quot; and symbol character is ".
 * -    Single Quote Mark: the entity is &apos; and symbol character is '.
 * -    Ampersand: the entity is &amp; and symbol character is &.
 * -    Greater Than Sign: the entity is &gt; and symbol character is >.
 * -    Less Than Sign: the entity is &lt; and symbol character is <.
 * -    Slash: the entity is &frasl; and symbol character is /.
 *
 * Given the input text string to the HTML parser, you have to implement the entity parser.
 *
 * Return the text after replacing the entities by the special characters.
 */
fun main(args: Array<String>) {
//    val input = "&amp; is an HTML entity but &ambassador; is not."
//    val input = "and I quote: &quot;...&quot;"
//    val input = "x &gt; y &amp;&amp; x &lt; y is always false"
    val input = "&amp;gt;"
    println(HtmlEntityParser.entityParser(input))
}

object HtmlEntityParser {

    fun entityParser(text: String): String = text
            .replace("&quot;", "\"")
            .replace("&apos;", "'")
            .replace("&gt;", ">")
            .replace("&lt;", "<")
            .replace("&frasl;", "/")
            .replace("&amp;", "&") // has to be the last one
}