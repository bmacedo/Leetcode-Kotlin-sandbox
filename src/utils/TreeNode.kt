package utils


data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun TreeNode.print() {
    BinaryTreePrinter(this).apply { print(System.out) }
}

class TreeBuilder {

    var value: Int = 0
    var pair: Pair<TreeBuilder?, TreeBuilder?> = Pair(null, null)

    fun value(function: () -> Int) {
        this.value = function()
    }

    fun left(function: (TreeBuilder.() -> Unit)? = null) {
        val leftNodeBuilder = TreeBuilder().apply {
            function?.invoke(this)
        }
        pair = pair.copy(first = leftNodeBuilder)
    }

    fun right(function: (TreeBuilder.() -> Unit)? = null) {
        val rightNodeBuilder = TreeBuilder().apply {
            function?.invoke(this)
        }
        pair = pair.copy(second= rightNodeBuilder)
    }

    fun build(): TreeNode = TreeNode(value).apply {
        left = pair.first?.build()
        right = pair.second?.build()
    }

}

fun root(function: TreeBuilder.() -> Unit): TreeNode =
        TreeBuilder().apply { function() }.build()

