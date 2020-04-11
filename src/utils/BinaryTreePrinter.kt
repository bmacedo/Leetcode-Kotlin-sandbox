package utils

import java.io.PrintStream

class BinaryTreePrinter(private val tree: TreeNode) {

    private fun traversePreOrder(root: TreeNode?): String {

        if (root == null) {
            return ""
        }

        val sb = StringBuilder()
        sb.append(root.`val`)

        val pointerRight = "└──"
        val pointerLeft = if (root.right != null) "├──" else "└──"

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null)
        traverseNodes(sb, "", pointerRight, root.right, false)

        return sb.toString()
    }

    private fun traverseNodes(sb: StringBuilder,
                              padding: String,
                              pointer: String,
                              node: TreeNode?,
                              hasRightSibling: Boolean) {

        if (node != null) {

            sb.append("\n")
            sb.append(padding)
            sb.append(pointer)
            sb.append(node.`val`)

            val paddingBuilder = StringBuilder(padding)
            if (hasRightSibling) {
                paddingBuilder.append("│  ")
            } else {
                paddingBuilder.append("   ")
            }

            val paddingForBoth = paddingBuilder.toString()
            val pointerRight = "└──"
            val pointerLeft = if (node.right != null) "├──" else "└──"

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null)
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false)

        }

    }

    fun print(os: PrintStream) {
        os.print(traversePreOrder(tree))
        println()
    }

}