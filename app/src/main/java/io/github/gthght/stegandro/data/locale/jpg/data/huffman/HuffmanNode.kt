package io.github.gthght.stegandro.data.locale.jpg.data.huffman

open class HuffmanNode {
    // can also represent the left node
    var node0: HuffmanNode? = null
    // can also represent the right node
    var node1: HuffmanNode? = null
    var parent: HuffmanNode? = null
    var symbol: Int = -1
    var isLeaf: Boolean = false


    val isFull: Boolean
        get() = node0 != null && node1 != null

    fun addChild(node: HuffmanNode) {
        if (node0 == null) {
            node0 = node
        } else if (node1 == null) {
            node1 = node
        } else {
            throw IllegalStateException("Node full.")
        }
        node.parent = this
    }

    fun level(): Int {
        return parent?.let { it.level() + 1 } ?: 0
    }

    override fun toString(): String {
        return "Node($symbol, isLeaf=$isLeaf, isFull=$isFull)"
    }

    companion object {
        fun printCode(root: HuffmanNode) = printCode(root, "")

        private fun printCode(root: HuffmanNode, s: String) {
            // base case; if the left and right are null
            // then its a leaf node and we print
            // the code s generated by traversing the tree.
            if (root.isLeaf) {
                return
            }
            // if we go to left then add "0" to the code.
            // if we go to the right add"1" to the code.

            // recursive calls for left and
            // right subtree of the generated tree.

            root.node0?.let {
                printCode(it, "${s}0")
            }

            root.node1?.let {
                printCode(it, "${s}1")
            }
        }
    }

    init {
        this.symbol = -1
    }
}